package com.deniz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deniz.dao.OgrenciDAO;
import com.deniz.domain.Ogrenci;

@Service
public class OgrenciServiceImpl implements OgrenciService {
	
	@Autowired
	OgrenciDAO ogrenciDAO;;
	
	@Transactional
	@Override
	public List<Ogrenci> getOgrenciler() {
		
		return ogrenciDAO.getOgrenciler();
	}
	
	@Transactional
	@Override
	public Ogrenci getOgrenci(int id) {
		
		return ogrenciDAO.getOgrenci(id);
	}

	@Transactional
	@Override
	public void saveOgrenci(Ogrenci ogrenci) {
		
		ogrenciDAO.saveOgrenci(ogrenci);
	}

	@Transactional
	@Override
	public Ogrenci getOgrencifromOgrNo(int ogrNo) {
		
		return ogrenciDAO.getOgrencifromOgrNo(ogrNo);
	}
	
	

}
