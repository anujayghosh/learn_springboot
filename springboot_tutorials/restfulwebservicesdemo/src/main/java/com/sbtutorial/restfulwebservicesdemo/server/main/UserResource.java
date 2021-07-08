package com.sbtutorial.restfulwebservicesdemo.server.main;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sbtutorial.restfulwebservicesdemo.server.main.model.User;

@RestController
public class UserResource {
	@Autowired
	private UserDAOService service;

	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		return service.findAll();
	}

//retrieves a specific user detail  
	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id) {
		return service.findOne(id);
	}

}