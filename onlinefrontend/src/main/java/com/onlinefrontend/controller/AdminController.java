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
import org.springframework.web.servlet.ModelAndView;

import com.onlinebackend.dao.CategoryDao;
import com.onlinebackend.dao.SupplierDao;
import com.onlinebackend.model.Category;
import com.onlinebackend.model.Supplier;

@Controller
public class AdminController {
	@Autowired SupplierDao supplierDao;	
	@Autowired CategoryDao categoryDao;	
	@RequestMapping("/admin")	 
    public ModelAndView indexAdmin(){
		 ModelAndView mv=new ModelAndView("AdminAdding");       
         mv.addObject("title", "Admin View");
         Supplier supplier=new Supplier();
         mv.addObject("supplier",supplier);
         mv.addObject("supplierList", supplierDao.getAllSupplier());
         
         Category category=new Category();
         mv.addObject("category",category);
         mv.addObject("categoryList", categoryDao.getAllCategory());
         return mv;
	}
	@RequestMapping(value = "/admin/supplier", method=RequestMethod.POST)
	public String supplierPost(@Valid @ModelAttribute("supplier") Supplier supplier, 
			BindingResult results, Model model,HttpServletRequest request) 	   
	{
		if(results.hasErrors())
			model.addAttribute("msg","Error in insert");
		
			if(supplierDao.insertSupp(supplier))
			{
				model.addAttribute("msg","Record Insertted Successfully");
				model.addAttribute("type","supplier");
				model.addAttribute("supplierList", supplierDao.getAllSupplier());		         
			}
			return "redirect:/admin";
	
	}
	@RequestMapping(value = "/admin/supplier/update", method=RequestMethod.POST)
	public String supplierUpdate(@Valid @ModelAttribute("supplier") Supplier supplier, 
			BindingResult results, Model model,HttpServletRequest request) 	   
	{
		if(results.hasErrors())
			model.addAttribute("msg","Error in Update");
		
			if(supplierDao.updateSupp(supplier))
			{
				model.addAttribute("msg","Record Updated Successfully");
				
				model.addAttribute("supplierList", supplierDao.getAllSupplier());
		         
			}
			return "redirect:/admin";
	
	}
	@RequestMapping("/admin/supplier/{sid}/remove")
	public String supplierRemove(@PathVariable int sid) 
	{
		Supplier supplier=supplierDao.getSupplierById(sid);   
	System.out.println(supplier.getSupplierName());	
	supplierDao.deleteSupp(supplier);
		return "redirect:/admin";
	}
	@RequestMapping("/admin/supplier/{sid}/edit")
	public ModelAndView supplierEdit(@PathVariable int sid) 
	{
		 ModelAndView mv=new ModelAndView("AdminAdding");       
         mv.addObject("title", "Supplier Edit");
         Supplier supplier=new Supplier();
         mv.addObject("supplier",supplier);
         mv.addObject("cmd","edit");
         mv.addObject("id",sid);
         mv.addObject("supplierList", supplierDao.getAllSupplier());
        
         Category category=new Category();
         mv.addObject("category",category);
         mv.addObject("categoryList", categoryDao.getAllCategory());
        
         return mv;
	
	}

	
	@RequestMapping(value = "/admin/category", method=RequestMethod.POST)
	public String categoryPost(@Valid @ModelAttribute("category") Category category, 
			BindingResult results, Model model,HttpServletRequest request) 	   
	{
		if(results.hasErrors())
			model.addAttribute("msg","Error in insert");
		
			if(categoryDao.insertCategory(category))
			{
				model.addAttribute("msg","Record Insertted Successfully");
				model.addAttribute("supplierList", categoryDao.getAllCategory());		         
			}
			return "redirect:/admin";
	
	}
	
	@RequestMapping(value = "/admin/category/update", method=RequestMethod.POST)
	public String categoryUpdate(@Valid @ModelAttribute("category") Category category, 
			BindingResult results, Model model,HttpServletRequest request) 	   
	{
		if(results.hasErrors())
			model.addAttribute("msg","Error in Update");
		
			if(categoryDao.updateCategory(category))
			{
				model.addAttribute("msg","Record Updated Successfully");
				
				model.addAttribute("categoryList", categoryDao.getAllCategory());
		         
			}
			return "redirect:/admin";
	
	}
	@RequestMapping("/admin/category/{sid}/remove")
	public String categoryRemove(@PathVariable int sid) 
	{
		Category category=categoryDao.getCategoryById(sid);   
		categoryDao.deleteCategory(category);
		return "redirect:/admin";
	}
	@RequestMapping("/admin/category/{sid}/edit")
	public ModelAndView categoryEdit(@PathVariable int sid) 
	{
		 ModelAndView mv=new ModelAndView("AdminAdding");       
         mv.addObject("title", "Admin Edit");
         Category category=new Category();
         mv.addObject("category",category);
         mv.addObject("cmd","edit");
         mv.addObject("id",sid);
         mv.addObject("categoryList", categoryDao.getAllCategory());

         Supplier supplier=new Supplier();
         mv.addObject("supplier",supplier);
         mv.addObject("supplierList", supplierDao.getAllSupplier());

         return mv;
	
	}

	
}
