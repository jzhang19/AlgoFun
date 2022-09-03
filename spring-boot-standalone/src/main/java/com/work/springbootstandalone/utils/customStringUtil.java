package com.work.springbootstandalone.utils;



import org.springframework.util.StringUtils;

import com.work.springbootstandalone.configs.Constants;
import com.work.springbootstandalone.models.Address;

public final class customStringUtil {

    // Parses each line into a string array
    public static String[] parseLine(String input) {
        String[] lineArr = input.split("\",\"");
        for (int i = 0; i < lineArr.length; i++) {
            lineArr[i] = lineArr[i].replaceAll("\"|,|\s+$|\\.", "");
        }
        return lineArr;
    }

    public static String formatAddress(Address address) {
        String[] components = {address.getAddress(), address.getCity(), address.getZone()};
        return String.join(", ", components);
    }
}
