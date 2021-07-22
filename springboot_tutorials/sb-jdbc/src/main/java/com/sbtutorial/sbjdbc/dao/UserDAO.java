package com.sbtutorial.sbjdbc.dao;

import java.util.Collection;

import com.sbtutorial.sbjdbc.model.User;

public interface UserDAO {
	
	public abstract void createUser(User user);
	   public abstract void updateUser(String id, User user);
	   public abstract void deleteUser(String id);
	   public abstract void truncateUser();
	   public abstract Collection<User> getUsers();
	

}
