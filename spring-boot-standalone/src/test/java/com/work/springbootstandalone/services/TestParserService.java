package com.work.springbootstandalone.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestParserService {

    private ParserService parserService;

    @BeforeEach
    public void init() {
        parserService = new ParserService();
    }
    
    @Test
    public void testParsingFile() throws Exception {
        Path workingDir = Paths.get("unitTestFiles").toAbsolutePath();
        parserService.parsingFile(workingDir.toString() + "/testInput1.txt");
		parserService.displayHouseholds(workingDir.toString() + "/testOutput1.txt");
        StringBuilder expected = new StringBuilder()
        .append("Household: 345 3rd Blvd Apt 200, Seattle, WA, Occupants Number: 2")
        .append("George, Brown, 345 3rd Blvd Apt 200, Seattle, WA, 18")
        .append("Helen, Brown, 345 3rd Blvd Apt 200, Seattle, WA, 18")
        .append("Household: 123 Main St, Seattle, WA, Occupants Number: 3")
        .append("Alice, Smith, 123 Main St, Seattle, WA, 45")
        .append("Dave, Smith, 123 Main St, Seattle, WA, 43")
        .append("Jane, Smith, 123 Main St, Seattle, WA, 13");

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(workingDir.toString() + "/testOutput1.txt"))) {
            String actual = reader.lines().collect(Collectors.joining());
            assertEquals(expected.toString(), actual);
        } catch (Exception ex) {
            throw ex;
        }

    }
}
