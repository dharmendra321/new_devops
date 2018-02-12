package com.onlinefrontend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.onlinebackend.dao.CategoryDao;
import com.onlinebackend.dao.ProductDao;
import com.onlinebackend.dao.UserDao;
import com.onlinebackend.model.Category;
import com.onlinebackend.model.Product;
import com.onlinebackend.model.UserDetails;



@Controller
public class IndexController {
	
	
	@Autowired UserDao userdao;
	@Autowired ProductDao productDao;
	@Autowired CategoryDao categoryDao;
	
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
	@RequestMapping("/login")	 
    public ModelAndView login(@RequestParam(name="error",required=false)String error ){
		 ModelAndView mv=new ModelAndView("login");       
         mv.addObject("title", "Login");
         if(error!=null)
        	 mv.addObject("message", "User Name or Password Not Correct!!!");
         return mv;
	}		
	@RequestMapping("/register")	 
    public ModelAndView login( ){
		 ModelAndView mv=new ModelAndView("registeruser");       
         UserDetails userdetails=new UserDetails();
         mv.addObject("userdetails", userdetails);
		 mv.addObject("title", "Register YourSelf");
         return mv;
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)	 
    public ModelAndView loginPost(@ModelAttribute("userdetails") UserDetails userdetails){
		 userdetails.setActive(true);
         userdetails.setUserRole("USER");      
		userdao.insertUser(userdetails);
		 ModelAndView mv=new ModelAndView("registeruser");       
         mv.addObject("message", "Thank your for Registering With Us!!!Please Click on Login to Login");
		 mv.addObject("title", "Register YourSelf");
         return mv;
	}
	@RequestMapping("/category/{cid}")
	public ModelAndView categoryList(@PathVariable int cid) 
	{
		ModelAndView mv=new ModelAndView("home");
	//	mv.addObject("id", cid);
		mv.addObject("products",productDao.getProductCategoryWise(cid));
		return mv;
	}
	@ModelAttribute("products") 
	public List<Product> modelProducts() {
		return productDao.getAllProduct();
	}
	@ModelAttribute("category") 
	public List<Category> modelCategory() {
		return categoryDao.getAllCategory();
	}
}
