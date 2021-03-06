package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @RequestMapping is generic while @GetMapping is specific for GET
 * 
 * For Bean to be returned as JSON getter should be there(for Jackson auto conversion)
 * @RestController has @ResponseBody which is responsible for messageConverters usage 
 * while returning response
 * 
 * SpringBoot autoConfiguration configures Jackson message Converters
 * 
 * i18N 
 * 		Add locale resolver in configuration(SpringApplication as bean)
 * 		Add ResourceBundleMessageSource in configuration(SpringApplication as bean)
 * 		Add message.properties(per Locale)
 * 		Autowire messageSource and use =>refer helloWorldInternationalized()
 *
 *	version 2
 *		Spring provides LocaleContextHolder with locale set from Header(Accept-Language)
 *			when used with AcceptHeaderLocaleResolver
 *		ResourceBundleMessageSource Bean can be removed as it can be 
 *			configured in application.properties itself
 *	refer RestfulWebServicesApplication.java and application.properties
 *	
 */
@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource; 

	@GetMapping("/hello-world")
	//@GetMapping(path = "/hello-world") // even 'path' is not needed
	//@RequestMapping(method=RequestMethod.GET, path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	///hello-world/path-variable/in28minutes
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

	//version 1
	// in header(Accept-Language) if not set so use default and hence required=false
	/*@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
	//public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, 
									locale);
	}*/
	//version 2
	//Spring provides LocaleContextHolder with locale set from Header(Accept-Language)
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, 
									LocaleContextHolder.getLocale());
	}

}
