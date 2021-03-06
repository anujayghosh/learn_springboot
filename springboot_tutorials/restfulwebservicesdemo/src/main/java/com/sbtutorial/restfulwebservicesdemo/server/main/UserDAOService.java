package com.sbtutorial.restfulwebservicesdemo.server.main;
	
import java.util.ArrayList;  
import java.util.Date;  
import java.util.List;  
import org.springframework.stereotype.Component;

import com.sbtutorial.restfulwebservicesdemo.server.main.model.User; 

@Component  
public class UserDAOService 
{ 
	public static int usersCount=5;  
	//creating an instance of ArrayList  
	private static List<User> users=new ArrayList<>();  
	//static block   
	static  
	{  
		//adding users to the list  
		users.add(new User(1, "Anujay", new Date()));  
		users.add(new User(2, "Rishitha", new Date()));  
		users.add(new User(3, "Varun", new Date()));  
		users.add(new User(4, "Manisha", new Date()));  
		users.add(new User(5, "Arpita", new Date()));  
	}  
	//method that retrieve all users from the list  
	public List<User> findAll()  
	{  
		return users;  
	}  
	//method that add the user in the list   
	public User save(User user)  
	{  
		if(user.getId()==null)  
		{  
			//increments the user id  
			user.setId(++usersCount);  
		}  
		users.add(user);  
		return user;  
	}  
	//method that find a particular user from the list  
	public User findOne(int id)  
	{  
		for(User user:users)  
		{  
			if(user.getId()==id)  
				return user;  
		}  
		return null;  
	}  

}
