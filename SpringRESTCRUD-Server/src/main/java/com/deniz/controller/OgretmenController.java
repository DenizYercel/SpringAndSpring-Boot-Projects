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

import com.deniz.entity.Ogretmen;
import com.deniz.service.OgretmenService;



@Controller
@RequestMapping("ogretmen")
public class OgretmenController {
	
	@Autowired
	OgretmenService ogretmenService;
	
	
	

	// @RequestMapping(path = "/list",method = RequestMethod.GET)
	//@PostMapping("list") Post i�in formlarda kullan�l�r. GET NORMAL SAYFALARDA
	
	@GetMapping("/list")
	public String showOgretmenList(Model model) {
		
		
		List<Ogretmen> ogretmenList=ogretmenService.getTeachers();
		
		model.addAttribute("ogrenciler", ogretmenList);
		
		return "ogretmen-list";
	}
	
	
	@GetMapping("/ogretmen-ekle")
	public String addOgretmen(Model model) {
		
		
		
		Ogretmen ogretmen=new Ogretmen();
		model.addAttribute("ogretmen", ogretmen);
		
		return "ogretmen-form";
	}
	
	@PostMapping("/ogretmen-kaydet")
	public String ogretmenKaydet(@Valid @ModelAttribute ("ogretmen") Ogretmen ogr,BindingResult bindingResult) {
		
		
		ogretmenService.saveTeacher(ogr);
		return "redirect:/ogretmen/list";
	}
	
	@GetMapping("ogretmen-guncelle")
	public String  ogretmenUpdate(Model model,@RequestParam("ogretmenId")int ogretmenId) {
		
		
		
		Ogretmen ogretmen =ogretmenService.getTeacher(ogretmenId);	
		model.addAttribute("ogretmen", ogretmen);
		
		return "ogretmen-form";
	}
	
	
	@GetMapping("ogretmen-sil")
	public String  ogretmenDelete(@RequestParam("ogretmenId")int ogretmenId) {
		
		
		
		ogretmenService.deleteTeacher(ogretmenId);	
		
		return "redirect:/ogretmen/list";
	}
	
}
