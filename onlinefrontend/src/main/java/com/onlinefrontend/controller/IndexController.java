package com.onlinefrontend.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.onlinebackend.dao.SupplierDao;
import com.onlinebackend.model.Supplier;



@Controller
public class IndexController {
	
	
	@RequestMapping(value = {"/", "/home", "/index"})	 
    public ModelAndView index(){
        ModelAndView mv=new ModelAndView("home");
        mv.addObject("title","Online Shoping");
        return mv;
	}
	@RequestMapping("/about")	 
    public ModelAndView about(){
		 ModelAndView mv=new ModelAndView("about");       
         mv.addObject("title", "About us");
         return mv;
	}
	@RequestMapping(value="/contact")	 
    public ModelAndView contact(){
        ModelAndView mv=new ModelAndView("contact");
        mv.addObject("title","Contact Us");
        return mv;
	}
	

}
