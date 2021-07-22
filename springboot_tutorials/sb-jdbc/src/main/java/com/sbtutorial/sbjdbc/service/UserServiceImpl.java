package com.sbtutorial.sbjdbc.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbtutorial.sbjdbc.dao.UserDAO;
import com.sbtutorial.sbjdbc.model.User;


@Service
public class UserServiceImpl implements UserService{

	//	private static Map<String, User> userRepo = new HashMap<>();
	//	@Autowired
	//	JdbcTemplate jdbc;
	@Autowired
	private UserDAO userDAO;
	@Override
	public void createUser(User user) {
		userDAO.createUser(user);
	}
	@Override
	public void updateUser(String id, User user) {
		userDAO.updateUser(id, user);
	}
	@Override
	public void deleteUser(String id) {
		userDAO.deleteUser(id);

	}
	@Override
	public void truncateUser()
	{
		userDAO.truncateUser();
	}
	@Override
	public Collection<User> getUsers() {
		return userDAO.getUsers();
	}

}
