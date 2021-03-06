package com.onlinebackend.dao;

import java.util.List;

import com.onlinebackend.model.Product;


public interface ProductDao {
	Product getProductById(int id);
	List<Product> getAllProduct();
	List<Product> getProductCategoryWise(int cid);
	boolean insertProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);
}
