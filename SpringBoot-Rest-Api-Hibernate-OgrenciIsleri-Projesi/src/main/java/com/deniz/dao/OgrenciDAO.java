package com.deniz.dao;

import java.util.List;

import com.deniz.domain.Ogrenci;

public interface OgrenciDAO {

	List<Ogrenci> getOgrenciler();

	Ogrenci getOgrenci(int id);
	
	void saveOgrenci(Ogrenci ogrenci);

	Ogrenci getOgrencifromOgrNo(int ogrNo);

}
