package com.onlinefrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlinebackend.dao.ProductDao;
import com.onlinebackend.model.Product;

@Controller
@RequestMapping("/data/json")
public class JsonController {
	@Autowired ProductDao productDao;
	
	@RequestMapping("/product/all")
	@ResponseBody
	public List<Product> getAllProductJson()
	{
		return productDao.getAllProduct();
	}
	@RequestMapping("/product/{cid}")
	@ResponseBody
	public List<Product> getProductByCategoryJson(@PathVariable int cid)
	{
		return productDao.getProductCategoryWise(cid);
	}

}
 