package com.deniz.springboot.project.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deniz.springboot.project.entity.Ogrenci;
import com.deniz.springboot.project.service.KitapService;

@RestController
@RequestMapping("/api")
public class KitapRestController {
	
	private KitapService kitapService;
	

	// inject kitap dao (use constructor injection)
	@Autowired
	public KitapRestController(KitapService kitapService) {
		this.kitapService = kitapService;
	}
	
	
	
	@GetMapping("/{indeks}")
	public Ogrenci getOgr(@PathVariable int indeks){
		 Ogrenci ogr=kitapService.getOgrenci(indeks);
		 
		 if(ogr!=null) {
			 return ogr;
		 }
		 else {
			 return null;
		 }
	}
	

}
