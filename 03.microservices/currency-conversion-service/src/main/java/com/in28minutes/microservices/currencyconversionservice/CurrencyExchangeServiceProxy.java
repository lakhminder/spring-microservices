package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 1* @FeignClient(name="currency-exchange-service", url="localhost:8000")
// 2* Feign (with ribon) with only service name, url handled by Ribbon
// 2* @FeignClient(name="currency-exchange-service")
// 3* route through Zuul API Gateway
@FeignClient(name="netflix-zuul-api-gateway-server")
// 2*3* Feign with Ribbon for load balancing , for list of servers refer application.properties
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	// 1*2* @GetMapping("/currency-exchange/from/{from}/to/{to}")
	// 3* Zuul require {service name}/{uri}
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue
		(@PathVariable("from") String from, @PathVariable("to") String to);
}
