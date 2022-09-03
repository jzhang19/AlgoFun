package com.work.springbootstandalone.utils;

import com.work.springbootstandalone.configs.Constants;

public final class customStringUtil {

    // Parses each line into a string array
    public static String[] parseLine(String input) {
        String[] lineArr = input.split("\",\"");
        for (int i = 0; i < lineArr.length; i++) {
            lineArr[i] = lineArr[i].replace("\"", "");
        }
        return lineArr;
    }
}
