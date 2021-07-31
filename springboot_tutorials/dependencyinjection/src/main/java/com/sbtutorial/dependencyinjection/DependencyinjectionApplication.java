package com.sbtutorial.dependencyinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DependencyinjectionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(DependencyinjectionApplication.class, args);

		Employee e1=ctx.getBean(Employee.class);
		e1.display();
	}

}
