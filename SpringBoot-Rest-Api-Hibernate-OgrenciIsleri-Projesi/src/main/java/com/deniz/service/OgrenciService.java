package com.deniz.service;

import java.util.List;

import com.deniz.domain.Ogrenci;

public interface OgrenciService {

	List<Ogrenci> getOgrenciler();

	Ogrenci getOgrenci(int id);
	
	void saveOgrenci(Ogrenci ogrenci);

	Ogrenci getOgrencifromOgrNo(int ogrNo);
}
