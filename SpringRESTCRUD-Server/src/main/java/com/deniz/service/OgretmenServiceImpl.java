package com.deniz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deniz.dao.OgretmenDAO;
import com.deniz.entity.Ogretmen;
@Service
public class OgretmenServiceImpl implements OgretmenService{

	
	@Autowired
	OgretmenDAO ogretmenDAO;
	
	@Transactional
	@Override
	public List<Ogretmen> getTeachers() {
		
		return	ogretmenDAO.getTeachers();
		
	}

	
	@Transactional
	@Override
	public void saveTeacher(Ogretmen ogretmen) {
		
		ogretmenDAO.saveTeacher(ogretmen);
		
	}

	
	@Transactional
	@Override
	public Ogretmen getTeacher(int ogretmenId) {
		
		return ogretmenDAO.getTeacher(ogretmenId);
	}

	
	@Transactional
	@Override
	public void deleteTeacher(int ogretmenId) {
		
		ogretmenDAO.deleteTeacher(ogretmenId);
		
		
	}

}
