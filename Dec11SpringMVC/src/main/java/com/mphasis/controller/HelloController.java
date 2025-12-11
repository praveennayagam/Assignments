package com.mphasis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello...";
    }

    @RequestMapping("/myname")
    public ModelAndView getName() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("name"); // resolves to /WEB-INF/views/name.jsp
        return mv;
    }
}
