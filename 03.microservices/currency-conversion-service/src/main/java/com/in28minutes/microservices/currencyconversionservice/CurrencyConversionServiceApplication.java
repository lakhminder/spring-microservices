package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

/**
 * 
 * Will use RestTemplate to invoke other service => refer Controller
 * Feign Rest client is used for invoking other Microservices
 * 1) Enable feign client with package to scan
 * 2) write FeignClient as proxy for MicroService
 * 3) invoke proxy methods to invoke service
 * 
 * Ribbon is used for Client Side Load Balancing => refer proxy
 * 
 * Eureka discovery client is used for clint for Naming Server(Eureka)
 * Eureka is used for Service registry and discovery
 *
 * Add Sampler as Bean in individual services for enabling Sleuth for all requests
 */
@SpringBootApplication
@EnableFeignClients("com.in28minutes.microservices.currencyconversionservice")
@EnableDiscoveryClient
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
