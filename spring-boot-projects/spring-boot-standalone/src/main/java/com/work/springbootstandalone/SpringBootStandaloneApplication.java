package com.work.springbootstandalone;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.work.springbootstandalone.services.ParserService;

@SpringBootApplication
public class SpringBootStandaloneApplication implements CommandLineRunner {

	@Autowired
	private ParserService parserService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStandaloneApplication.class, args);
	}

	public void run(String... args) throws Exception {
		try {
			// Current working directory
			Path workingDir = Paths.get("spring-boot-projects/spring-boot-standalone/testFiles").toAbsolutePath();
			parserService.parsingFile(workingDir.toString() + "/input.txt");
			parserService.displayHouseholds(workingDir.toString() + "/output.txt");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
