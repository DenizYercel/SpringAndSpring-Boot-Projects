package com.deniz.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deniz.dao.EmployeeDAO;
import com.deniz.entity.Department;
import com.deniz.entity.Employee;
import com.deniz.entity.JOB;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDAO employeeDAO;

	@Transactional
	@Override
	public List<Employee> getEmployees() {
		return employeeDAO.getEmployees();
	}

	@Transactional
	@Override
	public void saveEmployee(Employee employee) {
		
		employeeDAO.saveEmployee(employee);
		
	}

	
	
	@Transactional
	@Override
	public List<JOB> getJobs() {
		
		
		return employeeDAO.getJobs();
	}
	
	@Transactional
	@Override
	public List<Department> getDepartments() {
		return employeeDAO.getDepartments();
	}
	
	
	@Transactional
	@Override
	public List<Employee> getManegerId() {
		return employeeDAO.getManegerId();
	}

	@Transactional
	@Override
	public Employee getEmployee(int empId) {
	  return employeeDAO.getEmployee(empId);
	}

	@Transactional
	@Override
	public void deleteEmployee(int empId) {
		
		employeeDAO.deleteEmployee(empId);
		
	}

	@Transactional
	@Override
	public JOB getJob(String jobId) {
		return employeeDAO.getJob(jobId);
	}

	@Transactional
	@Override
	public List<Employee> searchEmployee(Employee employee) {
		return employeeDAO.searchEmployee(employee);
	}

	
	

}
