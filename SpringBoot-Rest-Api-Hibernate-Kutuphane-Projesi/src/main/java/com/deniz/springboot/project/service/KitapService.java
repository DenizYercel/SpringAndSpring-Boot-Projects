package com.deniz.springboot.project.service;

import java.util.List;

import com.deniz.springboot.project.entity.Kitap;
import com.deniz.springboot.project.entity.Ogrenci;


public interface KitapService {
	
	List<Kitap> getKitaplar();

	void saveKitap(Kitap ktp);

	Kitap getKitap(int id);

	Ogrenci getOgrenci(int indeks);


}
