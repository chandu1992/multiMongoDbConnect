package com.jarvis.multipleMongoDB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MultipleMongoDbApplication {

	static Logger logger = LoggerFactory.getLogger(MultipleMongoDbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MultipleMongoDbApplication.class, args);
	}

	private final Environment environment;

	public MultipleMongoDbApplication(Environment environment) {
		this.environment = environment;
	}

	@Profile("preprod")
	@Bean
	public String preProdBean(){
		logger.info("************************* We are using preprod Environment ****************************");
		System.out.println(environment.getProperty("server.port"));
		return "This is preprod environment.";
	}

	@Profile("prod")
	@Bean
	public String prodBean(){
		logger.info("************************* We are using prod Environment ****************************");
		return "This is prod environment.";
	}

}
