package com.work.springbootstandalone.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.cglib.transform.impl.AddDelegateTransformer;
import org.springframework.stereotype.Service;

import com.work.springbootstandalone.models.Address;
import com.work.springbootstandalone.models.Household;
import com.work.springbootstandalone.models.Occupant;
import com.work.springbootstandalone.utils.customStringUtil;

@Service
public class ParserService {

    private Map<String, Household> householdMap = new HashMap<String, Household>();
    
    public Boolean parsingFile(String filePath) {

        List<String> lines = new ArrayList<String>();

        // Putting buffer in a try-with-resources statement because BufferedReader implements the interface Autocloseable
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {

            lines = reader.lines().collect(Collectors.toList());
            for (String line : lines) {

                String[] lineArr = customStringUtil.parseLine(line);

                Address newAddress = new Address(lineArr[2], null, lineArr[3], lineArr[4], null);
                Occupant newOccupant = new Occupant(lineArr[0], lineArr[1], Integer.parseInt(lineArr[5]), newAddress);
                
                String key = String.join("-", new String[] {lineArr[4], lineArr[3], lineArr[2]});
                Household foundHousehold = householdMap.getOrDefault(key, new Household());
                List<Occupant> foundOccupants = foundHousehold.getOccupants();
                foundOccupants.add(newOccupant);

                householdMap.put(key, foundHousehold);
            }


            System.out.println(lines);
            System.out.println(householdMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return true;
    }

    public Boolean displayHouseholds(String filePath) {
        
        
        try {
            Path path = Paths.get(filePath);
            FileChannel.open(path, StandardOpenOption.WRITE).truncate(0).close();

            for (Entry<String, Household> entry : householdMap.entrySet()) {

                Household household = entry.getValue();
                
                StringBuilder content = new StringBuilder().append("Location: ").append(entry.getKey()).append(", Number of occupants: ").append(household.getOccupants().size()).append("\n");

                Files.writeString(path, content, StandardOpenOption.APPEND);

            }
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }
}
