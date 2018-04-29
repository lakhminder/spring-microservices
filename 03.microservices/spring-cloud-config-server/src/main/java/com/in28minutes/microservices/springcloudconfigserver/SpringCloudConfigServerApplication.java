package com.in28minutes.microservices.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Steps to create => git-localconfig-repo(git repo created locally)
 * > cd git-localconfig-repo
 * > git init
 * --create properties file(limits-service.properties)
 * > git add -A
 * > git commit -m "message"
 * 
 * then change the application.properties to point to our local git repo
 * 
 * refer pom.xml for changes
 * 
 * check http://localhost:8888/limits-service/default => for properties
 *		 http://localhost:8888/limits-service/{ENV} => for dev/qa
 */
@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
	}
}
