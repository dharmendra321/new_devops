package com.onlinefrontend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping(value = {"/", "/home", "/index"})	 
    public ModelAndView index(){
        ModelAndView mv=new ModelAndView("home");
        mv.addObject("title","this is about us page");
        return mv;
	}

}
