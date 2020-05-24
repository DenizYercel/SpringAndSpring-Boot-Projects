package com.deniz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class Department {

	
	@Id
	@Column(name = "DEPARTMENT_ID")
	private Integer departmentId;
	
	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "" + departmentId + "";
	}
	

}
