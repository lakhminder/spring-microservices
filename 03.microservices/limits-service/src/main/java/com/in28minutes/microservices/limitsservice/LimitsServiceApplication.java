package com.in28minutes.microservices.limitsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 
 * check Configuration.java
 * 
 * Hystrix is used for Fault tolerance
 * 	1) define dependency in pom
 * 	2) @EnableHystrix in application
 * 	3) use @HystrixCommand(fallbackMethod="fallbackRetrieveConfiguration") to define fallback method
 * 		which will be invoked incase of any Exception	 
 * 		refer Controller
 *
 */
@SpringBootApplication
@EnableHystrix
public class LimitsServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(LimitsServiceApplication.class, args);
	}
}
