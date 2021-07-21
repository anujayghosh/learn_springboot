package com.sbtutorial.sbjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
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

	@Autowired
	JdbcTemplate jdbc;

	
	@RequestMapping("/insert")  
	public String insertUser(){  
		jdbc.execute("insert into user(name,email)values('Anujay','anujay.sanjoy.ghosh@accenture.com')");  
		return "Data Inserted Successfully";  
	}
	
	@RequestMapping("/truncate")  
	public String truncateUser(){  
		jdbc.execute("truncate user;");  
		return "User Table Data Truncated Successfully";  
	}
	
	@RequestMapping(value = "/users")
	   public ResponseEntity<Object> getProduct() {
	      return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	   }
	   @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	   public ResponseEntity<Object> 
	      updateProduct(@PathVariable("id") String id, @RequestBody User user) {
	      
	     userService.updateUser(id, user);
	     jdbc.execute(String.format("delete from user where id=%s",id));
	     jdbc.execute(String.format("insert into user(id,name,email)values('%s','%s','%s')",id,user.getName(),user.getEmail()));
	      return new ResponseEntity<>("User is updated successsfully", HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	   public ResponseEntity<Object> delete(@PathVariable("id") String id) {
	      userService.deleteUser(id);
	      jdbc.execute(String.format("delete from user where id=%s",id));
	      return new ResponseEntity<>("User is deleted successsfully", HttpStatus.OK);
	   }
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	   public ResponseEntity<Object> createUser(@RequestBody User user) {
	      userService.createUser(user);
	      jdbc.execute(String.format("insert into user(id,name,email)values('%s','%s','%s')",user.getId(),user.getName(),user.getEmail()));
	      return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
	   }
}