package com.deniz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deniz.entity.Department;
import com.deniz.entity.Employee;
import com.deniz.entity.JOB;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Employee> getEmployees() {
		
		Session session=sessionFactory.getCurrentSession();
		
		Query<Employee> query=session.createQuery("from Employee where isDelete=1",Employee.class);
		
		List<Employee> resultList=query.getResultList();
		
		return resultList;
		
	}

	@Override
	public void saveEmployee(Employee employee) {
		Session session=sessionFactory.getCurrentSession();
		employee.setFirstName(employee.getFirstName().substring(0,1).toUpperCase()+employee.getFirstName().substring(1));
		employee.setLastName(employee.getLastName().toUpperCase());
		employee.setEmail(employee.getEmail().toUpperCase());
		session.saveOrUpdate(employee);
		
		
	}

	@Override
	public List<JOB> getJobs() {
		Session session = sessionFactory.getCurrentSession();
		Query<JOB> query = session.createQuery("from JOB",JOB.class);
		List<JOB> jobList =query.getResultList();
		
		return jobList;
	}

	@Override
	public List<Department> getDepartments() {
		Session session = sessionFactory.getCurrentSession();
		Query<Department> query = session.createQuery("from Department",Department.class);
		List<Department> departmentsList =query.getResultList();
		return departmentsList;
	}

	@Override
	public List<Employee> getManegerId() {
		Session session = sessionFactory.getCurrentSession();
		Query<Employee> query = session.createQuery("from Employee",Employee.class);
		List<Employee> managerId =query.getResultList();
		return managerId;
	}  

	@Override
	public Employee getEmployee(int empId) {
		
		Session session=sessionFactory.getCurrentSession();
		
		Employee emp=session.get(Employee.class,empId);
		
		return emp;
	}

	@Override
	public void deleteEmployee(int empId) {
		
		Session session=sessionFactory.getCurrentSession();
		//Employee emp=session.get(Employee.class, empId);
		//session.delete(emp);
		
		
		session.createQuery("update Employee set isDelete=0 where id="+empId).executeUpdate();
	}

	@Override
	public JOB getJob(String jobId) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(JOB.class, jobId);
	}

	@Override
	public List<Employee> searchEmployee(Employee employee) {
		String kriter ="from Employee where isDelete=1 ";
		
		if(employee.getEmployee_Id()!=null)
		kriter+=" and employee_Id like '%"+employee.getEmployee_Id()+"%' ";
		
		if(employee.getFirstName()!=null)
			kriter+=" and firstName like '%"+employee.getFirstName()+"%' ";
		
		if(!employee.getLastName().equals(""))
			kriter+=" and lastName like '%"+employee.getLastName()+"%' ";
		
		
		
		
		if(!employee.getJob().getJobId().equals(""))
			kriter+=" and job like '"+employee.getJob().getJobId()+"'";
		
		
		
		if(employee.getManager().getEmployee_Id()!=null)
			kriter+=" and manager="+employee.getManager().getEmployee_Id();
		
		if(employee.getDepartment().getDepartmentId()!=null)
			kriter+=" and department="+employee.getDepartment().getDepartmentId();

		System.out.println(kriter);
		Session session = sessionFactory.getCurrentSession();
		List<Employee> searchEmp =session.createQuery(kriter, Employee.class).getResultList();
		
		return searchEmp;
	}

	
	
	
	
}
