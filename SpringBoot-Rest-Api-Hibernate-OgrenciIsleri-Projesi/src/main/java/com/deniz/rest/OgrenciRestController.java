package com.deniz.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deniz.domain.Ogrenci;
import com.deniz.service.OgrenciService;

@RestController
@RequestMapping("/api")
public class OgrenciRestController {
	
	@Autowired
	OgrenciService ogrenciService;
	
	
	@GetMapping("/{ogrNo}")
	public Ogrenci getAktifOgr(@PathVariable int ogrNo){
			
		return ogrenciService.getOgrencifromOgrNo(ogrNo);		
	}
}
	