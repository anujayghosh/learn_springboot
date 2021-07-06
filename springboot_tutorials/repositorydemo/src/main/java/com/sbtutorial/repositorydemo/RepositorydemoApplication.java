package com.sbtutorial.repositorydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class RepositorydemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(RepositorydemoApplication.class, args);
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        userService.saveUser(new User(10, "Ramesh"));
	}

}
