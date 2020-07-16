package com.UserDetailsPOC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserDetailsPocApplication {

	private static Logger logger = LoggerFactory.getLogger(UserDetailsPocApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(UserDetailsPocApplication.class, args);
		logger.info("User Service Started!!!");
	}

}
