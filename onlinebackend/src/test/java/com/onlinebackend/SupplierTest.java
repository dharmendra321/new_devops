package com.onlinebackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlinebackend.dao.SupplierDao;
import com.onlinebackend.daoImpl.SupplierDaoImpl;
import com.onlinebackend.model.Supplier;

public class SupplierTest {
  private static SupplierDao supplierDao; 
  private static AnnotationConfigApplicationContext context;
  
  @BeforeClass
  public static void init()
  {
	  context=new AnnotationConfigApplicationContext();
	  context.scan("com.onlinebackend");
	  context.refresh();
	supplierDao=(SupplierDao)context.getBean("supplierDao");
  }
  @Test
  public void supplierAddTest()
  {
	  Supplier supplier =new Supplier();
	 // supplier.setSid(17);
	  supplier.setSupplierName("Manoj");
	 assertEquals("Record inserted Successfully",true,supplierDao.insertSupp(supplier));
  }
  @Test
  public void supplierUpdateTest()
  {
	  //Supplier supplier =supplierDao.getSupplierById(2);
	  //supplier.setSupplierName("Sanjay");
	  //assertEquals("Record Updated Successfully",true,supplierDao.updateSupp(supplier));
  }
  @Test
  public void supplierDeleteTest()
  {
	//  Supplier supplier =supplierDao.getSupplierById(2);
	  //assertEquals("Record Deleted Successfully",true,supplierDao.deleteSupp(supplier));
  
  }

}
