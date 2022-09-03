package com.work.springbootstandalone;

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
		parserService.parsingFile("E:\\workspace\\AlgoFun\\spring-boot-standalone\\input.txt");
		parserService.displayHouseholds("E:\\workspace\\AlgoFun\\spring-boot-standalone\\output.txt");
		
	}

}
