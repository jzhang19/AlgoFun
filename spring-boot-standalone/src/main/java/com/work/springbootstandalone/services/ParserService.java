package com.work.springbootstandalone.services;

import java.io.BufferedReader;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Service;

import com.work.springbootstandalone.models.Address;
import com.work.springbootstandalone.models.Household;
import com.work.springbootstandalone.models.Occupant;
import com.work.springbootstandalone.utils.customStringUtil;

@Service
public class ParserService {

    private Map<String, Household> householdMap = new HashMap<String, Household>();
    
    public void parsingFile(String filePath) throws Exception {

        // Putting buffer in a try-with-resources statement because BufferedReader implements the interface Autocloseable
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {

            List<String> lines = new ArrayList<String>();
            lines = reader.lines().collect(Collectors.toList());
            for (int i = 0; i < lines.size(); i++) {

                try {
                    String[] lineArr = customStringUtil.parseLine(lines.get(i));
                    Address newAddress = new Address(WordUtils.capitalizeFully(lineArr[2]), null, StringUtils.capitalize(lineArr[3]), StringUtils.upperCase(lineArr[4]), null);
                    Occupant newOccupant = new Occupant(StringUtils.capitalize(lineArr[0]), StringUtils.capitalize(lineArr[1]), Integer.parseInt(lineArr[5]));
                    
                    String key = customStringUtil.formatAddress(newAddress);
                    Household foundHousehold = householdMap.getOrDefault(key, new Household(newAddress, new ArrayList<Occupant>()));
                    foundHousehold.getOccupants().add(newOccupant);
                    householdMap.put(key, foundHousehold);
                } catch (Exception ex) {
                    System.out.printf("Parsing line %d failed, skipping it\n", i + 1);
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void displayHouseholds(String filePath) throws Exception {
        
        try {
            // Clean the content
            Path path = Paths.get(filePath);
            FileChannel.open(path, StandardOpenOption.WRITE).truncate(0).close();

            for (Entry<String, Household> entry : householdMap.entrySet()) {

                // Household
                Household household = entry.getValue();
                StringBuilder content = new StringBuilder()
                .append("Household: ").append(entry.getKey())
                .append(", Occupants Number: ").append(household.getOccupants().size()).append("\n");
                Files.writeString(path, content, StandardOpenOption.APPEND);

                // Occupants
                if (household.getOccupants().size() > 0) {
                    for (Occupant occupant : household.getOccupants()) {
                        content = new StringBuilder()
                        .append(occupant.getFirstName()).append(", ")
                        .append(occupant.getLastName()).append(", ")
                        .append(customStringUtil.formatAddress(household.getAddress())).append(", ")
                        .append(occupant.getAge()).append('\n');
                        Files.writeString(path, content, StandardOpenOption.APPEND);
                    }
                }
                
                // Make a new line between every household to display clearner
                Files.writeString(path, new StringBuilder().append('\n'), StandardOpenOption.APPEND);
            }

        } catch (Exception ex) {
            throw ex;
        }
    }
}
