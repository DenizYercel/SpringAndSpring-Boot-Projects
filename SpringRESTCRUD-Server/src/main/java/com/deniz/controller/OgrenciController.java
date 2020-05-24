package com.deniz.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deniz.entity.Ogrenci;
import com.deniz.service.OgrenciService;

@Controller
@RequestMapping("ogrenci")
public class OgrenciController {
	
	@Autowired
	OgrenciService ogrenciService;
	
	
	

	// @RequestMapping(path = "/list",method = RequestMethod.GET)
	//@PostMapping("list") Post i�in formlarda kullan�l�r. GET NORMAL SAYFALARDA
	
	@GetMapping("/list")
	public String showOgrList(Model model) {
		
		
		List<Ogrenci> ogrList=ogrenciService.getOgrenciler();
		
		model.addAttribute("ogrenciler", ogrList);
		
		return "ogrenci-list";
	}
	
	
	@GetMapping("/ogrenci-ekle")
	public String addOgrenci(Model model) {
		
		
		
		Ogrenci ogr=new Ogrenci();
		model.addAttribute("ogrenci", ogr);
		
		return "ogrenci-form";
	}
	
	@PostMapping("/ogrenci-kaydet")
	public String ogrenciKaydet(@Valid @ModelAttribute ("ogrenci") Ogrenci ogr,BindingResult bindingResult) {
		
		
		ogrenciService.saveOgrenci(ogr);
		return "redirect:/ogrenci/list";
	}
	
	@GetMapping("ogrenci-guncelle")
	public String  ogrenciUpdate(Model model,@RequestParam("ogrenciId")int ogrId) {
		
		
		
		Ogrenci ogr=ogrenciService.getOgrenci(ogrId);	
		model.addAttribute("ogrenci", ogr);
		
		return "ogrenci-form";
	}
	
	
	@GetMapping("ogrenci-sil")
	public String  ogrenciDelete(@RequestParam("ogrenciId")int ogrId) {
		
		
		
		ogrenciService.deleteOgrenci(ogrId);	
		
		return "redirect:/ogrenci/list";
	}
	
}
