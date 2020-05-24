package com.deniz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.deniz.entity.Employee;
import com.deniz.entity.Kurs;
import com.deniz.entity.Ogretmen;
import com.deniz.service.KursService;
import com.deniz.service.LoginService;

@Controller
@RequestMapping("kurs")
public class KursController {
	
	@Autowired
	KursService kursService;
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/list")
	public String showKursList(Model model) {
		
		if(!loginService.isLogin()) {
			return "redirect:/";
		}
		
		List<Kurs>  krsList=kursService.getKurslar();
		model.addAttribute("kurs", krsList);
		
		model.addAttribute("searchKurs", new Kurs());
		
		return "kurs-list";
	}
	
	@GetMapping("/kurs-ekle")
	public String addKurs(Model model) {
		
		if(!loginService.isLogin()) {
			return "redirect:/";
		}
		Kurs kurs=new Kurs();
		
		model.addAttribute("kurs", kurs);
		
		return "kurs-form";
	}
	
	@PostMapping("/kurs-kaydet")
	public String kursKaydet(@Valid @ModelAttribute("kurs")Kurs kurs,BindingResult bindingResult) {
		
		if(!loginService.isLogin()) {
			return "redirect:/";
		}
		
		if(bindingResult.hasErrors()) {
			return "kurs-form";
		}
		
		kursService.saveKurs(kurs);
		
		return "redirect:/kurs/list";
	}
	
	@GetMapping("kurs-guncelle")
	public String kursUpdate(Model model,@RequestParam("kursId")int kursId) {
		
		if(!loginService.isLogin()) {
			return "redirect:/";
		}
		
		Kurs kurs=kursService.getKurs(kursId);
		model.addAttribute("kurs", kurs);
		
		return "kurs-form";
	}
	
	@GetMapping("kurs-sil")
	public String kursDelete(@RequestParam("kursId")int kursId) {
		
		if(!loginService.isLogin()) {
			return "redirect:/";
		}
		
		kursService.deleteKurs(kursId);
		
		return "redirect:/kurs/list";
	}
	
	
	@PostMapping("/kurs-search")
	public String searchKurs(Model model,@ModelAttribute("searchKurs")Kurs kurs) {
		
		if(!loginService.isLogin()) {
			return "redirect:/";
		}
		
		List<Kurs> searchKurs=kursService.searchKurs(kurs);
		
		model.addAttribute("kurs", searchKurs);
		
	
		return "kurs-list";
	}
	
	@ModelAttribute("ogretmen")
	public Map<Integer, Integer> getOgretmen(){
		Map<Integer, Integer> ogretments=new HashMap<Integer, Integer>();
		
		List<Ogretmen> ogretmenList=kursService.getOgretmen();
		
		for (Ogretmen ogretmen : ogretmenList) {
			ogretments.put(ogretmen.getOgretmenId(),ogretmen.getOgretmenId());
		}
		return ogretments;
	}

}
