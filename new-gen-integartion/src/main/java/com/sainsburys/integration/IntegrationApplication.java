package com.sainsburys.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//same as @Configuration, @EnableAutoConfiguration, @ComponentScan combined
@SpringBootApplication
public class IntegrationApplication {

	public static void main(String[] args) {
		System.out.println("Initializing Spring Boot Application");
		SpringApplication.run(IntegrationApplication.class, args);
	}
}
