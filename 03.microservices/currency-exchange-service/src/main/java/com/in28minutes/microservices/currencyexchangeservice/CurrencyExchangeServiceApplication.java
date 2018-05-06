package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

/**
 * 
 * Refer CurrencyExchangeController.java
 * Refer pom.xml for h2DB dependency
 * 	*.sql file in resources is picked automatically by H2
 * Refer application.properties to enable h2 console
 * 	localhost:8000/h2-console
 * 	login => 
 * 		driver class = org.h2.Driver
 * 		JDBC URL = jdbc:h2:mem:testdb
 * 		username = sa 
 *
 * Eureka discovery client is used for clint for Naming Server(Eureka)
 * Eureka is used for Service registry and discovery
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}

}
