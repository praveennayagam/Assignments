package com.mphasis.cnotroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

	@GetMapping("/")
	public String loginpage()
	{
		return "login";
	}
	@PostMapping("/login")
	public String login(@RequestParam("uname") String uname, @RequestParam("pwd") String pwd, Model model)
	{
		if(uname.equals("praveen")&& pwd.equals("12345")) {
			model.addAttribute(model);
			return "elcome";
		}
			
		else
			return "error";
	}
}
