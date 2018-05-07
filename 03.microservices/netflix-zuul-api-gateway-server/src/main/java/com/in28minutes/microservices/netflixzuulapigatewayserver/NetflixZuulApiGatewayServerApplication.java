package com.in28minutes.microservices.netflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

/**
 * 
 * ZuulProxy to setup as Zuul API Gateway server
 * Also enable as Eureka client i.e @EnableDiscoveryClient
 * 
 * refer application.properties
 * 
 * Apply Filters => refer ZuulLoggingFilter.java
 * 
 * Normal invocation of CE service
 * 		localhost:8000/currency-exchange/from/EUR/to/INR
 * Using Zuul API gateway
 * 		localhost:8765/{application-name}/{uri}
 * 	i.e localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/INR	
 * 
 * For Microservice invoking other microservice through Zuul refer currency-conversion-service's proxy class
 * 
 * Add Sampler as Bean in individual services for enabling Sleuth for all requests
 * 
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}
}
