package com.sbtutorial.restfulwebservicesdemo.server.main;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sbtutorial.restfulwebservicesdemo.server.main.model.User;

@RestController
public class UserResource {
	@Autowired
	private UserDAOService service;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

//retrieves a specific user detail  
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		return service.findOne(id);
	}
	
	//method that posts a new user detail   
//	@PostMapping("/users")  
//	public String createUser(@RequestBody User user)  
//	{  
//		User savedUser=service.save(user);  
//		return "Success: New user added successfully.";
//	}  
	
	@PostMapping("/users")  
	public ResponseEntity<Object> createUser(@RequestBody User user)  
	{  
	User savedUser=service.save(user);    
	URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();  
	return ResponseEntity.created(location).build();  
	}

}