package com.onlinebackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinebackend.dao.SupplierDao;
import com.onlinebackend.model.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	private SessionFactory sessionFactory;
	public boolean insertSupp(Supplier supplier) {
		// TODO Auto-generated method stub
		try{
		sessionFactory.getCurrentSession().persist(supplier);
		sessionFactory.getCurrentSession().flush();
		return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		
		}
		return false;
	}

	public boolean updateSupp(Supplier supplier) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			
			}
			return false;
	}

	public boolean deleteSupp(Supplier supplier) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			
			}
			return false;
	}

	public Supplier getSupplierById(int id) {
		// TODO Auto-generated method stub
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Supplier.class,Integer.valueOf(id));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;

	}

	public List<Supplier> getAllSupplier() {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().flush();
		return sessionFactory.getCurrentSession().createQuery("from Supplier",Supplier.class).getResultList();
	}

}
