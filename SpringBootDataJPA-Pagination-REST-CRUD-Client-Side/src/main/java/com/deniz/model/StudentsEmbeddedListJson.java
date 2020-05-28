package com.deniz.model;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class StudentsEmbeddedListJson extends RepresentationModel{
	
	private List<Student> students;

	
	
	
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
	
}
