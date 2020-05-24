package com.deniz.dao;

import com.deniz.entity.Login;

public interface LoginDAO {

	public Login getLogin();

	public boolean loginSuccess(String username, String password);
	
	public boolean isLogin();

	

}
