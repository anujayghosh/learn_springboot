package com.sbtutorial.webappdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebappdemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(WebappdemoApplication.class);
	
	public static void main(String[] args) {
		      logger.info("This is an INFO message");
		      logger.warn("This is a WARN message");
		      logger.error("This is an ERROR message");
		SpringApplication.run(WebappdemoApplication.class, args);
	}

}
