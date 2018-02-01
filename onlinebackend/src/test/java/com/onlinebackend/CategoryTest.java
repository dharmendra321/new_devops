package com.onlinebackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlinebackend.dao.CategoryDao;
import com.onlinebackend.model.Category;

public class CategoryTest {
	private static CategoryDao categoryDao; 
	  private static AnnotationConfigApplicationContext context;
	  
	  @BeforeClass
	  public static void init()
	  {
		  context=new AnnotationConfigApplicationContext();
		  context.scan("com.onlinebackend");
		  context.refresh();
		  categoryDao=(CategoryDao)context.getBean("categoryDao");
	  }
	  @Test
	  public void supplierAddTest()
	  {
		  Category category =new Category();
		 // category.setCid(7);
		  category.setCategoryName("Manoj");
		 assertEquals("Record inserted Successfully",true,categoryDao.insertCategory(category));
	  }
}
