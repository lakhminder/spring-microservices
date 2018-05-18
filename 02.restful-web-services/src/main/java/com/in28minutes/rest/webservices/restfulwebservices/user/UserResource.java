package com.in28minutes.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * 
 * @RequestBody is used to convert json message to Bean in Post request
 * refer createUser()
 * Java provides VAlidation by @Valid to check/validating input object (hibernate validator is on classpath
 * through starter web)
 * => refer createUser() and User.java and CustomizedResponseEntityExceptionHandler.java
 * 
 * see UserNotFoundException.java
 * 
 * For HATEOAS return Resource<User> instead of User
 * 	refer retrieveUser() 
 * 	returns "all-users", SERVER_PATH + "/users" using spring boot hateoas(ControllerLinkBuilder)
 *
 * For contentNegotiation refer pom.xml
 *
 * For Swagger Documentation refer SwaggerConfig.java
 * 
 * For Monitoring
 * 	add actuator and HAL browser in pom.xml
 * 	enable access in application.properties for actuator
 * open localhost:8080/actuator(if not work try 8080/application)
 * localhost:8080 or localhost:8080/browser for hal browser
 * 		in explorer type 'actuator'
 *
 */
@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	//public User retrieveUser(@PathVariable int id) {
	public Resource<User> retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		
		if(user==null)
			throw new UserNotFoundException("id-"+ id);
		
		
		//"all-users", SERVER_PATH + "/users"
		//retrieveAllUsers
		Resource<User> resource = new Resource<User>(user);
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));
		
		//HATEOAS
		
		return resource;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		
		if(user==null)
			throw new UserNotFoundException("id-"+ id);		
		
		//ResponseEntity.noContent(); can also be returned
	}

	//
	// input - details of user
	// output - CREATED & Return the created URI
	
	//HATEOAS
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		// CREATED
		// /user/{id}     savedUser.getId()
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest() // current request
			.path("/{id}") // append 
			.buildAndExpand(savedUser.getId()) // resolve id
			.toUri();
		
		// response with status created(201) and location
		// set in header
		return ResponseEntity.created(location).build();  
		
	}
}
