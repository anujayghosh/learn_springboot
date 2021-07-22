package com.sbtutorial.sbjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbtutorial.sbjdbc.model.User;
import com.sbtutorial.sbjdbc.service.UserService;

@RestController  
public class SbJdbcController {
	
	 @Autowired
	 UserService userService;

	@RequestMapping("/truncate")  
	public String 
		truncate(){  
		userService.truncateUser();
		return "User Table Data Truncated Successfully";  
	}
	
	@RequestMapping(value = "/users")
	   public ResponseEntity<Object> 
			getProduct() {
	      return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	   }
	   @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	   public ResponseEntity<Object> 
	   		update(@PathVariable("id") String id, @RequestBody User user) {
	      
	     userService.updateUser(id, user);
	      return new ResponseEntity<>("User is updated successfully", HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	   public ResponseEntity<Object> 
	   		delete(@PathVariable("id") String id) {
	      userService.deleteUser(id);
	      return new ResponseEntity<>("User is deleted successfully", HttpStatus.OK);
	   }
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	   public ResponseEntity<Object> 
			create(@RequestBody User user) {
	      userService.createUser(user);
	      return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
	   }
}