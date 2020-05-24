package com.deniz.dao;

import java.util.List;

import com.deniz.entity.Ogretmen;


public interface OgretmenDAO {
	
	public List<Ogretmen> getTeachers();
	
	public void saveTeacher(Ogretmen ogretmen);
	
	public Ogretmen getTeacher(int ogretmenId);

	public void deleteTeacher(int ogretmenId);

}
