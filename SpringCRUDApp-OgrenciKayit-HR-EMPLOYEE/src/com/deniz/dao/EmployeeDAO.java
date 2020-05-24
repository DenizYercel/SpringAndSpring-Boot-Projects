package com.deniz.dao;

import java.util.List;

import com.deniz.entity.Department;
import com.deniz.entity.Employee;
import com.deniz.entity.JOB;

public interface EmployeeDAO {
	
	public List<Employee>  getEmployees();
	
	public void  saveEmployee(Employee employee);
	
	public Employee getEmployee(int empId);
	
	public void deleteEmployee(int empId);
	
	
	public List<Employee> searchEmployee(Employee employee);
	
	
	public List<JOB> getJobs();

	public List<Department> getDepartments();

	public List<Employee> getManegerId(); 
	
	public JOB getJob(String jobId);
	
	
	
}
