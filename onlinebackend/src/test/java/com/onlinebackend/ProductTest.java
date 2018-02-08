package com.onlinebackend;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlinebackend.dao.ProductDao;
import com.onlinebackend.model.Product;

public class ProductTest {
	 private static ProductDao productDao; 
	 
	  private static AnnotationConfigApplicationContext context;
	  
	  @BeforeClass
	  public static void init()
	  {
		  context=new AnnotationConfigApplicationContext();
		  context.scan("com.onlinebackend");
		  context.refresh();
		productDao=(ProductDao)context.getBean("productDao");
	  }
	  /*@Test
	  public void productAddTest()
	  {
		  Product product =new Product();
		 // supplier.setSid(17);
		  product.setProductName("Manoj");
		 assertEquals("Record inserted Successfully",true,productDao.insertProduct(product));
	  }
	  @Test
	  public void productUpdateTest()
	  {
	  }
	  @Test
	  public void productDeleteTest()
	  {
	  }*/
	  @Test
	  public void productAllRecord()
	  {
		  System.out.println(productDao.getAllProduct().size());
		 
		  //System.out.println(product.get(0).toString());
		  //System.out.println(product.get(1).toString());
		  
	  }

}
