package com.deniz.service;

import com.deniz.entity.Login;

public interface LoginService {

	public Login getLogin();

	public boolean loginSuccess(String username, String password);

	
	public boolean isLogin();
	
	

}
