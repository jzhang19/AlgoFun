package com.work.springbootstandalone.utils;



import java.util.Comparator;

import org.springframework.util.StringUtils;

import com.work.springbootstandalone.configs.Constants;
import com.work.springbootstandalone.models.Address;
import com.work.springbootstandalone.models.Occupant;

public final class customStringUtil {

    // Parses each line into a string array
    public static String[] parseLine(String input) {
        String[] lineArr = input.split("\",\"");
        for (int i = 0; i < lineArr.length; i++) {
            lineArr[i] = lineArr[i].replaceAll("\"|,|\\.", "");
            lineArr[i] = lineArr[i].replaceAll("^\\s+|\s+$|\s+(?=\s)", "");
        }
        return lineArr;
    }

    public static String formatAddress(Address address) {
        String[] components = {address.getAddress(), address.getCity(), address.getZone()};
        return String.join(", ", components);
    }

    public static class occupantsComparator implements Comparator<Occupant> {

        @Override
        public int compare(Occupant o1, Occupant o2) {
            int ageCompare = (o1.getAge() <= 18 || o2.getAge() <= 18) ? 0 : 1;
            if (ageCompare == 0) {
                return ageCompare;
            } else {
                int lastNameCompare = o1.getLastName().compareTo(o2.getLastName());
                if (lastNameCompare == 0) {
                    int firstNameCompare = o1.getFirstName().compareTo(o2.getFirstName());
                    return firstNameCompare;
                } else {
                    return lastNameCompare;
                }
            }
        }  
    }
}
