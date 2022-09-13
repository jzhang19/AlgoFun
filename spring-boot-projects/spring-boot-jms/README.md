# Overview - Java JMS Listener

## Table of Contents
* [Problem](#problem)
* [Design](#design)
* [Testing](#testing)

## Problem
Create a spring starter project and write a jms listener to read messages either from ActiveMQ or Sqs. The code should be able to consume and log messages.

*Stretch - Create a dummy entity class to represent a table using H2 db (in memory) and query data using jpa repository. Table schema and data can be any samples (as the person sees fit).
*Stretch – Create a personal AWS account to setup the queue and run the code to consumer the messages”
- I setup an embedded Artemis ActiveMQ in this spring boot application. The JMS listener will consume the message and logs it in the terminal

## Design

* It uses spring initializr to configure a Java spring boot maven project using Java 17 and Spring Boot 3.0.0(M4). Spring Boot makes it easier to configure a production-ready spring application. Java 17 is the last LTS release which provides new features over the older versions. The JMS listener listens to the Artemis ActiveMQ. The postman post method localhost:8080/api/order/ produces a serialized json message which is deserialized and stored in the H2 in-memory db. 

* Project Structure
```
	|__src
	|___|__main
	|   |____|__ controllers
	|   |____|__ listeners
	|   |____|__ models
    |	|____|__ repository
    |	|   |____|__ JmsListenerApplication.java (Spring Boot main function)
	|   |__ resources
	|   |__tests
```

* H2 In-memory DB: http://localhost:8080/h2-console/login.jsp?jsessionid=1af9c8c700b5330a993ad2897a78c24d
- Driver Class: org.h2.Driver
- JDBC URL: jdbc:h2:mem:persondb
- Username: sa
- Password: 

## Testing
* How to run:
    1. Open this spring boot maven project in visual studio workspace
	2. Download the postman json collection (name=Jms Listener.postman_collection.json)
		* Here are the curls if postman isn't an option
			- Produce a message: 
				```
				curl --location --request POST 'localhost:8080/api/order/' \
				--header 'Content-Type: application/json' \
				--data-raw '{
					"firstName": "Alan",
					"lastName": "Zhang",
					"item": "pizza",
					"cost": "5"
				}'
				```
			- Check the messages in H2 in memory database
				```
				curl --location --request GET 'localhost:8080/api/order/orders'
				```
	3. Run the spring boot application
	4. Use the first curl to produce a message which will create an order record in the H2 in-memory datbase
	5. Use the second curl to check for all the records created in the in-memory database



