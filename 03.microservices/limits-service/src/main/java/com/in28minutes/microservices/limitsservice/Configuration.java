package com.in28minutes.microservices.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ConfigurationProperties look for properties in application.properties as
 * limits-service.minimum=99
 *
 * however here we are pulling from GIT repo so 
 * 1) properties are not defined here(application.properties)
 * 2) use bootstrap.properties instead of application.properties
 * 3) define spring.cloud.config.uri to connect to
 * check spring-cloud-config-server
 * 
 *
 */
@Component
@ConfigurationProperties("limits-service")
public class Configuration {
	
	private int minimum;
	private int maximum;

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public int getMaximum() {
		return maximum;
	}

}
