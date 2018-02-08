package com.onlinebackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinebackend.dao.ProductDao;
import com.onlinebackend.model.Product;
import com.onlinebackend.model.Supplier;
@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		try
		{
		return sessionFactory.getCurrentSession().get(Product.class,id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		try
		{
			return sessionFactory.getCurrentSession().createQuery("from Product",Product.class).getResultList();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

	public boolean insertProduct(Product product) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

}
