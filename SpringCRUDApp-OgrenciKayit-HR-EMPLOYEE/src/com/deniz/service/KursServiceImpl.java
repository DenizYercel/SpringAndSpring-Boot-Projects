package com.deniz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deniz.dao.KursDAO;
import com.deniz.entity.Kurs;
import com.deniz.entity.Ogretmen;

@Service
public class KursServiceImpl implements KursService{

	@Autowired
	private KursDAO kursDAO;
	
	@Transactional
	@Override
	public List<Kurs> getKurslar() {
		
		return kursDAO.getKurslar();
	}

	@Transactional
	@Override
	public void saveKurs(Kurs kurs) {
		
		kursDAO.saveKurs(kurs);
		
	}

	@Transactional
	@Override
	public Kurs getKurs(int kursId) {
		return kursDAO.getKurs(kursId);
	}

	@Transactional
	@Override
	public void deleteKurs(int kursId) {
		
		kursDAO.deleteKurs(kursId);
	}

	@Transactional
	@Override
	public List<Ogretmen> getOgretmen() {
		return kursDAO.getOgretmen();
	}

	@Transactional
	@Override
	public List<Kurs> searchKurs(Kurs kurs) {
		return kursDAO.searchKurs(kurs);
	}

}
