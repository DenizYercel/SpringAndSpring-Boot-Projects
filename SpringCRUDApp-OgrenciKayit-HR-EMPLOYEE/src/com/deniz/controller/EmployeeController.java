package com.deniz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deniz.entity.Department;
import com.deniz.entity.Employee;
import com.deniz.entity.JOB;
import com.deniz.service.EmployeeService;
import com.deniz.service.LoginService;


@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/list")
	public String showEmployeeList(Model model) {
		
		if(!loginService.isLogin()) {
			return "redirect:/";
		}
		
		List<Employee> empList=employeeService.getEmployees();
		
		model.addAttribute("employee", empList);
		
		model.addAttribute("employeeSearch",new Employee());
		
	
		return "employee-list";
	}
	
	@GetMapping("/employee-ekle")
	public String addEmployee(Model model){
		
		if(!loginService.isLogin()) {
			return "redirect:/";
		}
		Employee employee=new Employee();
		
		model.addAttribute("employee", employee);
		
		
		return "employee-form";
	}
	
	@PostMapping("employee-kaydet")
	public String ekleEmployee(@Valid @ModelAttribute("employee") Employee employee,Model model,BindingResult bindingResult) {
		
		if(!loginService.isLogin()) {
			return "redirect:/";
		}
		
		JOB job=employeeService.getJob(employee.getJob().getJobId());
		
		
		if(employee.getSalary()<job.getMinSalary()) {
			bindingResult.rejectValue("salary","error.employee","Minimum maaþtan("+job.getMinSalary()+")düþük olamaz!");
		}
		
		if(employee.getSalary()>job.getMaxSalary()) {
			bindingResult.rejectValue("salary", "error.emplooye", "Maximum maaþtan("+job.getMaxSalary()+") yüksek olamaz!");
			}
		
		if(bindingResult.hasErrors()) {
			return "employee-form";
		}
		
		employeeService.saveEmployee(employee);
		
				
		return "redirect:/employee/list";
	}
	
	@GetMapping("employee-guncelle")
	public String updateEmployee(Model model,@RequestParam("employeeId")int empId) {
		
		if(!loginService.isLogin()) {
			return "redirect:/";
		}
		
		Employee emp=employeeService.getEmployee(empId);
		
		model.addAttribute("employee", emp);
		
		return "employee-form";
	}
	
	@GetMapping("employee-sil")
	public String deleteEmployee(@RequestParam("employeeId")int empId) {
		
		if(!loginService.isLogin()) {
			return "redirect:/";
		}
		
		employeeService.deleteEmployee(empId);
		
		return "redirect:/employee/list";
	}
	
	
	@PostMapping("/employee-search")
	public String searchEmployee(Model model,@ModelAttribute("employeeSearch")Employee employee) {
		
		if(!loginService.isLogin()) {
			return "redirect:/";
		}
		
		List<Employee> searchEmp=employeeService.searchEmployee(employee);
		
		model.addAttribute("employee", searchEmp);
		
	
		return "employee-list";
	}
	
	
	@ModelAttribute("job")
	public Map<String,String> getJobs(){
		Map<String,String> jobs=new HashMap<String,String>();
		
		List<JOB> jobList=employeeService.getJobs();
		
		for (JOB job : jobList) {
			jobs.put(job.getJobId(), job.getJobTitle());
		}
		
		return jobs;
	}
	
	@ModelAttribute("department")
	public Map<Integer,String> getDepartment(){
		Map<Integer,String> departments=new HashMap<Integer,String>();
		
		List<Department> departmentList=employeeService.getDepartments();
		
		for (Department department : departmentList) {
			departments.put(department.getDepartmentId(), department.getDepartmentName());
		}
		
		return departments;
	}
	
	@ModelAttribute("manager")
	public Map<Integer,Employee> getManager(){
		Map<Integer,Employee> managers=new HashMap<Integer,Employee>();
		
		List<Employee> managerList=employeeService.getManegerId();
		
		for (Employee employee : managerList) {
			managers.put(employee.getEmployee_Id(), employee.getManager());
		}
		
		return managers;
	}
	
	
	

}
