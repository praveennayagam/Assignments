package com.mphasis.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mphasis.model.User;
import com.mphasis.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;
	
//	@GetMapping("/user/{id}")
//	public User userDetails(Long id)
//	{
//		return service.userDetails(id);
//	}
	
	@GetMapping("/user/{id}")
	public User userDetails(@PathVariable Long id) {
	    return service.userDetails(id);
	}


	
	
	@RequestMapping("/login")
	public ModelAndView login()
	{
		ModelAndView mv=new ModelAndView("login");
		return mv;
		
	}
	
	@RequestMapping("/home/{role}")
	public ModelAndView home(@PathVariable String role, 
			@RequestParam("uname") String uname,
			@RequestParam("pwd")String pwd)
	{
		boolean result=service.doAuthenticate(role,uname,pwd);
		ModelAndView mv=new ModelAndView();
		if(result) {
			if(role.equalsIgnoreCase("admin"))
			{
				mv.setViewName("list");
				List<User> userList=service.getUserList();
				mv.addObject("userList",userList);
			}
			else
				if(role.equalsIgnoreCase("user"))
				{
					mv.setViewName("list");
					mv.addObject("username",uname);
				}
				else
				{
					mv.setViewName("home");
					mv.addObject("username",uname);
				}
			
			
			
		}
		return mv;
	}

	
	@RequestMapping("/signup")
	public ModelAndView add()
	{
		return new ModelAndView("add");
	}
	
	@GetMapping("/home/userList")
	public ModelAndView  getUserList()
	{
		List<User> userList=service.getUserList();
		ModelAndView mv=new ModelAndView("list");
		mv.addObject("userList",userList);
		return mv;
	}

	@RequestMapping("/addUser")
	public ModelAndView addUser(@ModelAttribute("user") User user)
	{	
		
		
		ModelAndView mv=new ModelAndView("result");
		User u=service.addUser(user);
		mv.addObject("username",u.getUname());
		return mv;
	}
	

}
