package com.onlinebackend.dao;

import java.util.List;

import com.onlinebackend.model.Category;



public interface CategoryDao {
	Category getCategoryById(int id);
	List<Category> getAllCategory();
	boolean insertCategory(Category category);
	boolean updateCategory(Category category);
	boolean deleteCategory(Category category);

}
