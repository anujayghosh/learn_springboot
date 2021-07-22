package com.sbtutorial.sbjdbc.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sbtutorial.sbjdbc.model.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	private static Map<String, User> userRepo = new HashMap<>();
	@Autowired
	JdbcTemplate jdbc;
	
	public void createUser(User user) {
		userRepo.put(user.getId(), user);
		jdbc.execute(String.format("insert into user(id,name,email)values('%s','%s','%s')",user.getId(),user.getName(),user.getEmail()));
	}
	public void updateUser(String id, User user) {
		userRepo.remove(id);
		user.setId(id);
		userRepo.put(id, user);
		jdbc.execute(String.format("delete from user where id=%s",id));
		jdbc.execute(String.format("insert into user(id,name,email)values('%s','%s','%s')",id,user.getName(),user.getEmail()));
	}
	public void deleteUser(String id) {
		userRepo.remove(id);
		jdbc.execute(String.format("delete from user where id=%s",id));

	}
	public void truncateUser()
	{
		userRepo = new HashMap<>();
		jdbc.execute("truncate user;");
	}
	public Collection<User> getUsers() {
		return userRepo.values();
	}


}
