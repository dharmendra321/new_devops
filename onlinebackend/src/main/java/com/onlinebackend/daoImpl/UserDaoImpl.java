package com.onlinebackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinebackend.dao.UserDao;
import com.onlinebackend.model.UserDetails;
@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
		public boolean insertUser(UserDetails user) {
		// TODO Auto-generated method stub
			 try{
				 sessionFactory.getCurrentSession().persist(user);
				 return true;
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			return false;
	}

	public UserDetails getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteUser(UserDetails user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<UserDetails> getAllUserList() {
		// TODO Auto-generated method stub
		return null;
	}

}
