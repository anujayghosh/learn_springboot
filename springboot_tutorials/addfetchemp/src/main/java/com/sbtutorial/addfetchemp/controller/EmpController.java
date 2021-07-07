package com.sbtutorial.addfetchemp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/fetchEmp")
	public ModelAndView fetchEmp(@RequestParam int eid)
	{
		ModelAndView mv = new ModelAndView("showEmployee.jsp");
		Employee employee = employeeDAO.findById(eid).orElse(new Employee());
		mv.addObject(employee);
		return mv;
	}
	
	@RequestMapping("/updateEmp")
	public String updateEmp(Employee employee)
	{
		employeeDAO.deleteById(employee.getEid());
		employeeDAO.save(employee);
		return "home.jsp";
	}
	
	@RequestMapping("/deleteEmp")
	public String deleteEmp(@RequestParam int eid)
	{
		employeeDAO.deleteById(eid);
		return "home.jsp";
	}
}
