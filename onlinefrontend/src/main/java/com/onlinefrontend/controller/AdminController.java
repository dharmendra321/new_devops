package com.onlinefrontend.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.onlinebackend.dao.CategoryDao;
import com.onlinebackend.dao.ProductDao;
import com.onlinebackend.dao.SupplierDao;
import com.onlinebackend.model.Category;
import com.onlinebackend.model.Product;
import com.onlinebackend.model.Supplier;

@Controller
public class AdminController {
	@Autowired SupplierDao supplierDao;
	
	@Autowired CategoryDao categoryDao;	
	@Autowired ProductDao productDao;
	@RequestMapping("/admin/view")	 
    public ModelAndView indexAdmin(@ModelAttribute("type")String type){
		 ModelAndView mv=new ModelAndView("AdminAdding");       
         mv.addObject("title", "Admin View");
         Supplier supplier=new Supplier();
         mv.addObject("supplier",supplier);
         Category category=new Category();
         mv.addObject("category",category);
         Product product=new Product();
         mv.addObject("product",product);
       
         if(type.length()>0)
             mv.addObject("tp",type);        
         return mv;
	}
	
		
	
	@RequestMapping(value = "/admin/supplier", method=RequestMethod.POST)
	public String supplierPost(@Valid @ModelAttribute("supplier") Supplier supplier, 
			BindingResult results, Model model) 	   
	{
		if(results.hasErrors())
			model.addAttribute("msg","Error in insert");
		
			if(supplierDao.insertSupp(supplier))
			{
				model.addAttribute("title", "Admin View");
				model.addAttribute("msg","Record Insertted Successfully");
				model.addAttribute("type","supplier");
			}
			return "redirect:/admin/view";
	}

	@RequestMapping(value = "/admin/category", method=RequestMethod.POST)
	public String categoryPost(@Valid @ModelAttribute("category") Category category, 
			BindingResult results, Model model) 	   
	{
		if(categoryDao.insertCategory(category))
		{
			model.addAttribute("title", "Admin View");
	         
			model.addAttribute("msg","Record Insertted Successfully");
			model.addAttribute("type","category");
		}
		return "redirect:/admin/view";
	
	}
	@RequestMapping(value = "/admin/product", method=RequestMethod.POST)
	public String productPost(@Valid @ModelAttribute Product product, 
			BindingResult results, Model model,HttpServletRequest request) 	   
	{
		if((productDao.insertProduct(product)))
		{
			if(!product.getPic().getOriginalFilename().equals("") )
			{
				String REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/product/");
				MultipartFile file=product.getPic();
				try{
			file.transferTo(new File(REAL_PATH + product.getPid() + ".jpg"));
		//	file.transferTo(new File("D:/DTMY/file/new_devops/onlinefrontend/src/main/webapp/assets/images/product/" + product.getPid() + ".jpg"));
				}
				catch(IOException ex) {
					ex.printStackTrace();
				}				
			}
			
			model.addAttribute("title", "Admin View");
	         
			model.addAttribute("msg","Record Insertted Successfully");
			model.addAttribute("type","product");
		}
		return "redirect:/admin/view";
	
	}

	
	
	
	@RequestMapping(value = "/admin/supplier/update", method=RequestMethod.POST)
	public String supplierUpdate(@Valid @ModelAttribute("supplier") Supplier supplier, 
			BindingResult results, Model model) 	   
	{
		if(results.hasErrors())
			model.addAttribute("msg","Error in Update");
		
			if(supplierDao.updateSupp(supplier))
			{
				model.addAttribute("msg","Record Updated Successfully");
				model.addAttribute("type","supplier");
			}
			return "redirect:/admin/view";
	
	}
	@RequestMapping(value = "/admin/category/update", method=RequestMethod.POST)
	public String categoryUpdate(@Valid @ModelAttribute("category") Category category, 
			BindingResult results, Model model) 	   
	{
		if(results.hasErrors())
			model.addAttribute("msg","Error in Update");
		
			if(categoryDao.updateCategory(category))
			{
				model.addAttribute("msg","Record Updated Successfully");
				model.addAttribute("type","category");
			}
			return "redirect:/admin/view";
	
	}
	@RequestMapping(value = "/admin/product/update", method=RequestMethod.POST)
	public String productUpdate(@Valid @ModelAttribute("product") Product product, 
			BindingResult results, Model model) 	   
	{
		if(results.hasErrors())
			model.addAttribute("msg","Error in Update");
		
			if(productDao.updateProduct(product))
			{
				model.addAttribute("msg","Record Updated Successfully");
				model.addAttribute("type","productList");
			}
			return "redirect:/admin/view";
	
	}
	
	
	
	@RequestMapping("/admin/supplier/{sid}/remove")
	public String supplierRemove(@PathVariable int sid,Model model) 
	{
		Supplier supplier=supplierDao.getSupplierById(sid);   
	System.out.println(supplier.getSupplierName());	
	supplierDao.deleteSupp(supplier);
	model.addAttribute("type","supplier");
		return "redirect:/admin/view";
	}
	@RequestMapping("/admin/category/{sid}/remove")
	public String categoryRemove(@PathVariable int sid, Model model) 
	{
		Category category=categoryDao.getCategoryById(sid);   
		categoryDao.deleteCategory(category);
		model.addAttribute("type","category");
		
		return "redirect:/admin/view";
	}
	@RequestMapping("/admin/product/{pid}/remove")
	public String productRemove(@PathVariable int pid, Model model) 
	{
		Product product=productDao.getProductById(pid);   
		productDao.deleteProduct(product);
		model.addAttribute("type","productList");
		
		return "redirect:/admin/view";
	}
	
	@RequestMapping("/admin/supplier/{sid}/edit")
	public String supplierEdit(@PathVariable int sid,Model model) 
	{
		model.addAttribute("id",sid);
		model.addAttribute("cmd","edit");
		model.addAttribute("type","supplier");
		return "redirect:/admin/adminedit";
	}
	@RequestMapping("/admin/category/{sid}/edit")
	public String categoryEdit(@PathVariable int sid,Model model) 
	{
		model.addAttribute("id",sid);
		model.addAttribute("cmd","edit");
		model.addAttribute("type","category");
		return "redirect:/admin/adminedit";	
	}
	@RequestMapping("/admin/product/{pid}/edit")
	public String productEdit(@PathVariable int pid,Model model) 
	{
		model.addAttribute("id",pid);
		model.addAttribute("cmd","edit");
		model.addAttribute("type","productList");
		return "redirect:/admin/adminedit";	
	}
	
	
	@RequestMapping("/admin/adminedit")	 
    public ModelAndView indexAdminedit(@ModelAttribute("type")String type,@ModelAttribute("id")String id,
    		@ModelAttribute("cmd")String cmd){
		 ModelAndView mv=new ModelAndView("AdminAdding");       
         mv.addObject("title", "Admin View");
        
         Supplier supplier=new Supplier();
         mv.addObject("supplier",supplier);
         
         Category category=new Category();
         mv.addObject("category",category);
       
         Product product=new Product();
         mv.addObject("product",product);
       
         
         mv.addObject("tp",type);
         mv.addObject("id",id);
         mv.addObject("cmd",cmd);
         //mv.addObject("categoryList", categoryDao.getAllCategory());
         return mv;
	}
	
	@ModelAttribute("categories") 
	public List<Category> modelCategories() {
		return categoryDao.getAllCategory();
	}
	@ModelAttribute("suppliers") 
	public List<Supplier> modelSuppliers() {
		return supplierDao.getAllSupplier();
	}
	@ModelAttribute("products") 
	public List<Product> modelProducts() {
		return productDao.getAllProduct();
	}
	
	
}
