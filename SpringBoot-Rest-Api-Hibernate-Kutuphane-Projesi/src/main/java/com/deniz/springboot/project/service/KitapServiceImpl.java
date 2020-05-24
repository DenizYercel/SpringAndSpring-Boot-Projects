package com.deniz.springboot.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deniz.springboot.project.dao.KitapDAO;
import com.deniz.springboot.project.entity.Kitap;
import com.deniz.springboot.project.entity.Ogrenci;


@Service
public class KitapServiceImpl implements KitapService{
	
	
	private KitapDAO kitapDAO;
	
	

	@Autowired
	public KitapServiceImpl(KitapDAO kitapDAO) {
		this.kitapDAO = kitapDAO;
	}


	@Transactional
	@Override
	public List<Kitap> getKitaplar() {
		
		return kitapDAO.getKitaplar();
		
	}

	
	@Transactional
	@Override
	public void saveKitap(Kitap ktp) {
		
		kitapDAO.saveKitap(ktp);
		
	}

	
	@Transactional
	@Override
	public Kitap getKitap(int id) {
		
		return kitapDAO.getKitap(id);
	}

	
	@Transactional
	@Override
	public Ogrenci getOgrenci(int indeks) {
	
		return kitapDAO.getOgrenci(indeks);
		
	}

	

}
