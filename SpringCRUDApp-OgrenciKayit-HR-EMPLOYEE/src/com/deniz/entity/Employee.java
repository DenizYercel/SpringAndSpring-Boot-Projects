package com.deniz.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "EMPLOYEES")
public class Employee {

	@Id
	@Column(name = "EMPLOYEE_ID")
	@SequenceGenerator(name = "seq_employees",sequenceName = "EMPLOYEES_SEQ",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_employees")
	private Integer employee_Id;
	
	
	
	@Column(name ="FIRST_NAME")
	private String firstName;
	
	
	@Column(name = "LAST_NAME")
	private  String lastName;
	
	@NotEmpty@Email
	@Column(name = "EMAIL")
	private String email;
	
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	
	@Column(name = "HIRE_DATE")
	private Date hireDate;
	
	@Column(name = "IS_DELETE")
	private Integer isDelete=1;
	
	@ManyToOne
	@JoinColumn(name = "JOB_ID")
	private JOB job;
	
	@Min(value=0,message="minimum 0tl girmelisiniz")
	@Max(value=999999,message="maksimum  99999 yüksek olamaz")
	@Column(name = "SALARY")
	private double salary;
	
/*	@Column(name = "COMMISSION_PCT")
	private double commission_pct; */
	
	
	
	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;
	
	
	@ManyToOne
	@JoinColumn(name = "MANAGER_ID")
	private Employee manager;
	
	

	
	
	public Employee() {
		
	}

	

	public Employee(Integer employee_Id, String firstName, String lastName, @NotEmpty @Email String email,
			String phoneNumber, Date hireDate, Integer isDelete, JOB job,
			@Min(value = 0, message = "minimum 0tl girmelisiniz") @Max(value = 999999, message = "maksimum  99999 yüksek olamaz") double salary,
			Department department, Employee manager) {
		super();
		this.employee_Id = employee_Id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.isDelete = isDelete;
		this.job = job;
		this.salary = salary;
		this.department = department;
		this.manager = manager;
	}




	public Employee getManager() {
		return manager;
	}



	public void setManager(Employee manager) {
		this.manager = manager;
	}


	public Integer getEmployee_Id() {
		return employee_Id;
	}



	public void setEmployee_Id(Integer employee_Id) {
		this.employee_Id = employee_Id;
	}



	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	


	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	public JOB getJob() {
		return job;
	}



	public void setJob(JOB job) {
		this.job = job;
	}



	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


/*	public double getCommission_pct() {
		return commission_pct;
	}


	public void setCommission_pct(double commission_pct) {
		this.commission_pct = commission_pct;
	}
*/

	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}




	@Override
	public String toString() {
		return "" + employee_Id + "";
	}
	
	
	
}

