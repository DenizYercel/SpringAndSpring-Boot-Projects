package com.deniz.service;

import java.util.List;

import com.deniz.model.Page;
import com.deniz.model.Student;

public interface StudentService {

	public List<Student> getStudents(Integer page, Integer pageSize);

	public List<Student> getStudentsLink(String paramLink);

	public Student getStudent(int studentId);

	public void saveStudent(Student student);

	public void deleteStudent(int studentId);

	public int getPageSize();

	public int getTotal();

	public int getSize();

	public Page getPage();



}
