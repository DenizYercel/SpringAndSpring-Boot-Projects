package com.deniz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.deniz.domain.Ogrenci;
import com.deniz.service.OgrenciService;

@Controller
public class OgrenciController {
	
	static final String serverUrl = "http://localhost:8081/api/";
	static RestTemplate restTemplete = new RestTemplate();

	
	
	@Autowired
	OgrenciService ogrenciService;

	
	@RequestMapping("/")	
	public String test() {
		return "welcome";
	}
	
	@RequestMapping("/ogrenciisleri")	
	public String ogrList(Model model) {
		List<Ogrenci> ogrList=ogrenciService.getOgrenciler();
		model.addAttribute("ogrenciler",ogrList);	
		
		return "ogrenci-list";
	}
	
	
	@RequestMapping("/mezuniyet")	
	public String mezuniyet(@RequestParam("ogrenciId")int id,Model model) {
		Ogrenci ogrenci=ogrenciService.getOgrenci(id);
		model.addAttribute("ogr",ogrenci);
		return "ogrenci-form";
	}
	
	@PostMapping("/mezunEt")
	public String mezunEt(@ModelAttribute ("ogr") Ogrenci ogrenci,Model model) {
		
		;
		
		Ogrenci ogrGelen=ktphnKytSorgu(ogrenci.getId());
		
		//kutuphane kayit kontrol
		
		if(ogrGelen!=null) {
			String uyari= "UYARI  :  " + ogrenci.getOgrenciNo() +" "+" numarali ogrenci " + ogrenci.getAd()+" "+ogrenci.getSoyad()+" "+
			"kütüphane ile ilişigi bulunmaktadır.Mezun olamaz.";
			
			
			
			model.addAttribute("mesaj", uyari);
			
			
			List<Ogrenci> ogrList=ogrenciService.getOgrenciler();
			
			model.addAttribute("ogrenciler",ogrList);
			
				
			
			return "ogrenci-list";
		}
		
		ogrenciService.saveOgrenci(ogrenci);
		return "redirect:/ogrenciisleri";
		
	}
	
	public Ogrenci ktphnKytSorgu(int ogrId) {
		
		return restTemplete.getForObject(serverUrl + "/" + ogrId,Ogrenci.class);
		
	}
	

}
