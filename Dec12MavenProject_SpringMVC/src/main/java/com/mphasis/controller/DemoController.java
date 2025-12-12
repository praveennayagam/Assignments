package com.mphasis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mphasis.model.User;
import com.mphasis.service.DemoService;

@Controller
public class DemoController {
	@Autowired
	DemoService demoService;
	
	@RequestMapping("/login")
	public ModelAndView login()
	{
		ModelAndView mv=new ModelAndView("login");
		return mv;
		
	}
	@RequestMapping("/home/{role}")
	//@RequestParam("uname") String uname,@RequestParam("pwd")String pwd    
	//@PathVariable String uname,@PathVariable String  pwd
	//{uname}/{pwd}
	public ModelAndView home(@PathVariable String role,@RequestParam("uname") String uname,@RequestParam("pwd")String pwd)
	{
		boolean result=demoService.doAuthenticate(role,uname,pwd);
		if(result) {
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("Username",uname);
		return mv;
		}
		else
			return new ModelAndView("error");
	}
	
	@RequestMapping("/home/userInfo/{uname}")
	public ModelAndView userDetails(@PathVariable String uname)
	{
		User user =new User();
		user=demoService.userDetails(uname);
		ModelAndView mv=new ModelAndView("info");
		mv.addObject("user",user);
		return mv;
		
	}
	
	@RequestMapping("/signup")
	public ModelAndView add()
	{
		return new ModelAndView("add");
	}

	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") User user)
	{	
		
		User u=demoService.addUser(user);
		ModelAndView mv=new ModelAndView("result");
		mv.addObject("username",u.getUname());
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
