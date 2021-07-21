package com.sbtutorial.sbjdbc.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sbtutorial.sbjdbc.model.User;


@Service
public class UserServiceImpl implements UserService{
	
	private static Map<String, User> userRepo = new HashMap<>();
//	   static {
//	      User varun = new User();
//	      varun.setId("1");
//	      varun.setName("Varun");
//	      varun.setEmail("varun@accenture.com");
//	      userRepo.put(varun.getId(), varun);
//
//	      User rishitha = new User();
//	      rishitha.setId("2");
//	      rishitha.setName("Rishitha");
//	      rishitha.setEmail("rishitha@accenture.com");
//	      userRepo.put(rishitha.getId(), rishitha);
//	   }
	

	   @Override
	   public void createUser(User user) {
	      userRepo.put(user.getId(), user);
	   }
	   @Override
	   public void updateUser(String id, User user) {
	      userRepo.remove(id);
	      user.setId(id);
	      userRepo.put(id, user);
	   }
	   @Override
	   public void deleteUser(String id) {
	      userRepo.remove(id);

	   }
	   @Override
	   public Collection<User> getUsers() {
	      return userRepo.values();
	   }

}
