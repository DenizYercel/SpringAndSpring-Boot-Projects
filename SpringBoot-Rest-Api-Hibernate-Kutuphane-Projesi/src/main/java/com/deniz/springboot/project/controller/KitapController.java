package com.deniz.springboot.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.deniz.springboot.project.entity.Kitap;
import com.deniz.springboot.project.entity.Ogrenci;
import com.deniz.springboot.project.service.KitapService;



@Controller
public class KitapController {

	static final String serverUrl = "http://localhost:8082/api/";
	static RestTemplate restTemplete = new RestTemplate();


	@Autowired
	KitapService kitapService;

	@RequestMapping("/")	
	public String test() {
		return "welcome";
	}
	
	
	@RequestMapping("/kutuphaneisleri")	
	public String ktphnList(Model model) {
		List<Kitap> kitapList=kitapService.getKitaplar();
		model.addAttribute("kitaplar",kitapList);	
		
		return "kitap-list";
	}
	
	
	@RequestMapping("/oduncAl")	
	public String oduncAl(@RequestParam("kitapId")int id,Model model) {
		Kitap kitap=kitapService.getKitap(id);
		model.addAttribute("kitap",kitap);
		return "kitap-form";
	}
	
	@PostMapping("/kitapteslim")
	public String kitapTeslim(@ModelAttribute("kitap") Kitap ktp,Model model) {
		
		Ogrenci ogr=ogrAktfSorgu(ktp.getOgrenci().getOgrenciNo());
		
		//aktif öğrenci kontrol
		if(ogr==null) {
			String uyari="UYARI : Kayıtlarda "+ktp.getOgrenci().getOgrenciNo()+" nolu aktif öğrenci yoktur. "
					+ "İşlem gerçekleştirilemedi.";
			
			model.addAttribute("mesaj",uyari);
			List<Kitap> kitapList=kitapService.getKitaplar();
			model.addAttribute("kitaplar",kitapList);
			return "kitap-list";
		}
		
		ktp.setOgrenci(ogr);		
		kitapService.saveKitap(ktp);
		return "redirect:/kutuphaneisleri";
		
	}
	
	@RequestMapping("/ogrencibilgileri")	
	public String ogrBilgileri(@RequestParam("ogrNo")int ogrno,Model model) {
		Ogrenci ogrnc=ogrAktfSorgu(ogrno);
		model.addAttribute("ogr", ogrnc);
		return "OgrenciBilgileri";
	}
	
	public Ogrenci ogrAktfSorgu(int ogrNo) {
		
		return restTemplete.getForObject(serverUrl + "/" + ogrNo , Ogrenci.class);
		
	}
	
}
