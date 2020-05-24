package com.deniz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/home")
	public String showAdminPage() {
		return "admin-home";
	}
	
	@GetMapping("/task")
	public String adminTasks() {
		return "admin-tasks";
	}
}
