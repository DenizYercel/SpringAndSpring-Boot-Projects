package com.deniz.service;

import java.util.List;

import com.deniz.entity.Ogrenci;

public interface OgrenciService {

	public List<Ogrenci> getOgrenciler();
	
	public void saveOgrenci(Ogrenci ogr);
	
	public Ogrenci getOgrenci(int ogrId);
	
	public void deleteOgrenci(int ogrId);
}
