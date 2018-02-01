package com.onlinebackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinebackend.dao.CategoryDao;
import com.onlinebackend.model.Category;
@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	public Category getCategoryById(int id) {
		try
		{
			return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		// TODO Auto-generated method stub
		return null;
	}

	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		try
		{
			return sessionFactory.getCurrentSession().createQuery("from Category",Category.class).getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertCategory(Category category) {
		// TODO Auto-generated method stub
		try
		{

			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateCategory(Category category) {
		
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

}
