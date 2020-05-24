package com.deniz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deniz.dao.LoginDAO;
import com.deniz.entity.Login;

@Service
public class LoginServiceImpl implements LoginService {

	 @Autowired
	private LoginDAO loginDAO;
	
	@Transactional
	@Override
	public Login getLogin() {
		// TODO Auto-generated method stub
		return loginDAO.getLogin();
	}

	@Transactional
	@Override
	public boolean loginSuccess(String username, String password) {
		// TODO Auto-generated method stub
		return loginDAO.loginSuccess(username,password);
	}

	@Transactional
	@Override
	public boolean isLogin() {
		
		return	loginDAO.isLogin();
	}

	

}
