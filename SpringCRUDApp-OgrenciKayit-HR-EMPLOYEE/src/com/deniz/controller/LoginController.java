package com.deniz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.deniz.entity.Login;
import com.deniz.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@GetMapping("/")
	public String showHomePage(Model model) {

		Login login = loginService.getLogin();

		model.addAttribute("login", login);

	
		return "login";
	}

	@PostMapping("/logindb")
	public String loginDB(@Valid @ModelAttribute("login") Login login,BindingResult bindingResult) {

		
		
		String username = login.getUsername();

		String password = login.getPassword();
		
		
		if(bindingResult.hasErrors()) {
			return "login";
			
		}
		
		if (loginService.loginSuccess(username, password)) 
			return "index";	
		
		
			return "login";


	}

}
