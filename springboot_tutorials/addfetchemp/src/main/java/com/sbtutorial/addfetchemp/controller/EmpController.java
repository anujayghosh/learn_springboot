package com.sbtutorial.addfetchemp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbtutorial.addfetchemp.dao.EmployeeDAO;
import com.sbtutorial.addfetchemp.model.Employee;

@Controller
public class EmpController {
	
	@Autowired
	EmployeeDAO employeeDAO;

	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping("/addEmp")
	public String addEmp( Employee employee)
	{
		employeeDAO.save(employee);
		return "home.jsp";
	}
}
