# Overview - Java Standalone App

## Table of Contents
* [Problem](#problem)
* [Design](#design)
* [Testing](#testing)

## Problem
* Exercise Summary: This Developer Design and Development exercise is used in the evaluation process for potential new hire candidates.  Please approach this exercise as you would approach a design and development project at work and include unit tests.  Any documentation or explanations about your approach and assumptions are helpful.  Please post your completed exercise on Github and send a link back to your recruiting contact at Expeditors when complete.

* Requirements: Write a standalone executable or script using the language of your preference (Java is the primary dev language at Expeditors).  Given the provided input data, print the expected output to the console or write to a text file.  Please also include Java unit tests that test your code.

* Input data:
"Dave","Smith","123 main st.","seattle","wa","43"
"Alice","Smith","123 Main St.","Seattle","WA","45"
"Bob","Williams","234 2nd Ave.","Tacoma","WA","26"
"Carol","Johnson","234 2nd Ave","Seattle","WA","67"
"Eve","Smith","234 2nd Ave.","Tacoma","WA","25"
"Frank","Jones","234 2nd Ave.","Tacoma","FL","23"
"George","Brown","345 3rd Blvd., Apt. 200","Seattle","WA","18"
"Helen","Brown","345 3rd Blvd. Apt. 200","Seattle","WA","18"
"Ian","Smith","123 main st ","Seattle","Wa","18"
"Jane","Smith","123 Main St.","Seattle","WA","13"

* Expected output: 
- Each household and number of occupants, followed by:
- Each First Name, Last Name, Address and Age sorted by Last Name then First Name where the occupant(s) is older than 18

## Design

* It uses spring initializr to configure a Java spring boot maven project using Java 17 and Spring Boot 3.0.0(M4). Spring Boot makes it easier to configure a production-ready spring application. Java 17 is the last LTS release which provides new features over the older versions. 

* Project Structure
```
	|__src
	|___|__main
	|   |____|__ config
	|   |____|__ models
	|   |____|__ services (Parser Implementations)
    	|   |____|__ utils (Custom utility functions)
    	|   |____|__ TestApplication.java (Spring Boot main function)
	|   |__ resources
	|   |__tests
```

## Testing
* How to run:
    1. Download the spring-boot-standalone folder inside the ALGOFUN repository
    2. Import the spring-boot-standalone folder as a new workspace to Visual Studio Code
    3. Run the application
    4. Check the input.txt and output.txt files at /spring-boot-standalone/testFiles



