package com.work.springbootstandalone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStandaloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStandaloneApplication.class, args);
	}

	public void run(String... args) throws Exception {
		if (args.length > 0) {
			System.out.println();
		}
	}

}
