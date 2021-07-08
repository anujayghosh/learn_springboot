package com.sbtutorial.contentnegotiation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbtutorial.contentnegotiation.model.Employee;

@RestController
public class EmployeeController {
	
	/**
	 * Accept Header method:
	 * Use "Accept" Header in HTTP Request with "application/xml" or "application/json" and remove WebConfig.java from codebase
	 * Returns output based on Accept Header.
	 */

	@RequestMapping(value = "/employee", method = RequestMethod.GET,
			produces = { "application/json" }) //Using Content Negotiation to produce both XML and JSON format outputs.
	public ResponseEntity<Employee> firstPageJSON() {

		Employee emp = new Employee();
		emp.setName("Anujay Ghosh");
		emp.setDesignation("Application Development Associate");
		emp.setEmpId("1001");
		emp.setSalary(3000);

		return ResponseEntity.ok()
        .header("ANUJAY-Type of output", "JSON")
        .body(emp);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET,
			produces = { "application/xml" }) //Using Content Negotiation to produce both XML and JSON format outputs.
	public ResponseEntity<Employee> firstPageXML() {

		Employee emp = new Employee();
		emp.setName("Anujay Ghosh");
		emp.setDesignation("Application Development Associate");
		emp.setEmpId("1001");
		emp.setSalary(3000);

		return ResponseEntity.ok()
		        .header("ANUJAY-Type of output", "XML")
		        .body(emp);
	}
	
	
}
