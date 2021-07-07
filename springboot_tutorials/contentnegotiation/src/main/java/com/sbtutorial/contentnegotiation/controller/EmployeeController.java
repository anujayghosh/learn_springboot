package com.sbtutorial.contentnegotiation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbtutorial.contentnegotiation.model.Employee;

@RestController
public class EmployeeController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET,
			produces = { "application/json", "application/xml" }) //Using Content Negotiation to produce both XML and JSON format outputs.
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("Anujay Ghosh");
		emp.setDesignation("Application Development Associate");
		emp.setEmpId("1001");
		emp.setSalary(3000);

		return emp;
	}
}
