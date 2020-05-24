package com.deniz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deniz.entity.Login;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	Login login;
	

	@Autowired
	SessionFactory sessionFactory;

	
	@Override
	public Login getLogin() {
		
		System.out.println("kullanici"+ login);
		return login;
	}  

	
	@Override
	public boolean loginSuccess(String username, String password) {
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			Login loginControl =session.get(Login.class, username);
			
			if(loginControl.getUsername()==null || (loginControl.getPassword()==null)) {
				return false;
				
			}else if(loginControl.getPassword().equals(password)) {
				
				login.setUsername(loginControl.getUsername());
				login.setPassword(loginControl.getPassword());
				
				return true;
			}
			return false;
		} catch (Exception e) {
			
		}
				
		return false;
	}


	@Override
	public boolean isLogin() {
		if(login.getUsername()==null) {
			return false;
		}
		return true;
	}

	


}
