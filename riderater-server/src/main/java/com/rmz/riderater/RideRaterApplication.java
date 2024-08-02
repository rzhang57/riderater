package com.rmz.riderater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RideRaterApplication {


	private static final Logger log = LoggerFactory.getLogger(RideRaterApplication.class); // logger

	public static void main(String[] args) {
		SpringApplication.run(RideRaterApplication.class, args);
		log.info("Application started successfully!");
	}

}
