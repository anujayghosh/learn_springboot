package com.sbtutorial.restfulclient.delete;

import org.springframework.web.client.RestTemplate;

import com.sbtutorial.restfulclient.model.Employee;

public class DeleteAltExample {
	 
	   public static void main(String[] args) {
	 
	      RestTemplate restTemplate = new RestTemplate();
	 
	      // URL with URI-variable
	      String resourceUrl = "http://localhost:8080/employee/{empNo}";
	 
	      Object[] uriValues = new Object[] { "E01" };
	 
	      // Send request with DELETE method.
	      restTemplate.delete(resourceUrl, uriValues);
	 
	      Employee e = restTemplate.getForObject(resourceUrl, Employee.class);
	 
	      if (e != null) {
	         System.out.println("(Client side) Employee after delete: ");
	         System.out.println("Employee: " + e.getEmpNo() + " - " + e.getEmpName());
	      } else {
	         System.out.println("Employee not found!");
	      }
	   }
	 
	}