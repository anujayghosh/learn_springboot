package com.sbtutorial.contentnegotiation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
		
		//set path extension to true - depreciated to discourage path extension as method of content negotiation
		//favorPathExtension(true).
		configurer.favorParameter(false).
		parameterName("mediaType").
		//using Accept Header in HTTP Request to make the distinction
		ignoreAcceptHeader(false).
		defaultContentType(MediaType.APPLICATION_JSON).
		mediaType("xml", MediaType.APPLICATION_XML).
		mediaType("json", MediaType.APPLICATION_JSON);
	}
}
