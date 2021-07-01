package com.sbtutorial.componentscandemo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

/**
 * Using HttpServletRequest
 * Creating a session using HttpSession and then passing data+view
 */
//	@RequestMapping("home")
//	public String home(HttpServletRequest req)
//	{
//		HttpSession session = req.getSession();
//		String name= req.getParameter("name");
//		System.out.println("Request accepted. Name = "+name);
//		
//		session.setAttribute("name", name);
//		
//		return "home";
//	}
	
/**
 * WITHOUT Using HttpServletRequest
 * Using @RequestParam("")
 * Creating a session using HttpSession and then passing data+view
 */
//	@RequestMapping("home")
//	public String home(@RequestParam("name") String myName, HttpSession session)
//	{
//		System.out.println("Request accepted. Name = "+myName);
//		
//		session.setAttribute("name", myName);
//		
//		return "home";
//	}
/**
 * WITHOUT Using HttpServletRequest
 * WITHOUT Creating a session using HttpSession and then passing data+view
 * Using @RequestParam("")
 * Using ModelAndView 
 */
//	@RequestMapping("home")
//	public ModelAndView home(@RequestParam("name") String myName)
//	{
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("name",myName);
//		mv.setViewName("home");
//			
//		return mv;
//	}
/**
 * WITHOUT Using HttpServletRequest
 * WITHOUT Creating a session using HttpSession and then passing data+view
 * Using @RequestParam("")
 * Using ModelAndView 
 */
	
	@RequestMapping("home")
	public ModelAndView home(Employee employee)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("ob",employee);
		mv.setViewName("home");
			
		return mv;
	}
}
