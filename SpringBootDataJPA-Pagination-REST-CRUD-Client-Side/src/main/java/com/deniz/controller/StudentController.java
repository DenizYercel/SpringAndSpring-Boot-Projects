package com.deniz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deniz.model.Page;
import com.deniz.model.PageAs;
import com.deniz.model.Student;
import com.deniz.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/list")
	public String students(Model model, PageAs page, ModelMap modelMap) {

		if (page.getPage() == null || page.getPageSize() == null) {
			page.setPage(1);
			page.setPageSize(6);
		}

		 PageAs pageAs = new PageAs();
		model.addAttribute("pages", pageAs);
		List<Student> students = studentService.getStudents(page.getPage() - 1, page.getPageSize());
		model.addAttribute("students", students);
		
		Page pag = studentService.getPage();
		modelMap.put("p", page.getPage());
		modelMap.put("l", page.getPageSize());
		modelMap.put("total", pag.getTotalElements());
		
		return "student-list";
	}

	@GetMapping("list-link")
	public String studentsLink(Model model, @ModelAttribute("pages") PageAs page, ModelMap modelMap,
			@RequestParam("paramLink") String paramLink) {
		

		List<Student> students = studentService.getStudentsLink(paramLink);
		model.addAttribute("students", students);
		
		
		Page pag = studentService.getPage();
		System.out.println("pgagagagagagag"+pag.getNumber());
		if (paramLink.equals("first") || pag.getNumber()==0)
			modelMap.put("firstDis", "disabled");
		else if (paramLink.equals("last") || pag.getNumber()+1==pag.getTotalPages())
			modelMap.put("lastDis", "disabled");
		
		modelMap.put("p", pag.getNumber()+1);
		modelMap.put("l", pag.getSize());
		modelMap.put("total", pag.getTotalElements());
		return "student-list";
	}

	
	@GetMapping("/student-insert")
	public String insertStudent(Model model) {
		
		Student student = new Student();
		model.addAttribute("student",student);
		
		return "student-form";
	}
	
	
	@GetMapping("/student-update")
	public String updateStudent(@RequestParam("studentId") int studentId, Model model) {

		Student student = studentService.getStudent(studentId);
		model.addAttribute("student", student);

		return "student-form";
	}

	@GetMapping("/student-delete")
	public String deleteStudent(@RequestParam("studentId") int studentId) {
		studentService.deleteStudent(studentId);
		return "redirect:/student/list";
	}

	@PostMapping("/student-save")
	public String saveStudent(@ModelAttribute("student") Student student) {

		studentService.saveStudent(student);
		return "redirect:/student/list";
	}
	
	
}
