package com.sbtutorial.componentscandemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ComponentscandemoApplication {
	private static ApplicationContext applicationContext;

	@Bean
	public ExampleBean exampleBean() {
		return new ExampleBean();
	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(ComponentscandemoApplication.class, args);
		checkBeansPresence("employee", "exampleBean");

	}

	private static void checkBeansPresence(String... beans) {
		for (String beanName : beans) {
			System.out.println("Is " + beanName + " in ApplicationContext: " + 
					applicationContext.containsBean(beanName));
		}
	}

}
