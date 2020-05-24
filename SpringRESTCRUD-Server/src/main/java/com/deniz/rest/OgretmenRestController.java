package com.deniz.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deniz.entity.Ogretmen;
import com.deniz.service.OgretmenService;

@RestController
@RequestMapping("/api")
public class OgretmenRestController {
	
	@Autowired
	OgretmenService ogretmenService;
	
	@GetMapping("/ogretmenler")
	public List<Ogretmen> getOgretmenler() {
		
		return ogretmenService.getTeachers();
		
	}
	
	@GetMapping("/ogretmenler/{ogretmenId}")
	public Ogretmen ogretmen(@PathVariable int ogretmenId) {
		
		Ogretmen ogretmen = ogretmenService.getTeacher(ogretmenId);
		
		return ogretmen;
	}
	
	
	@PostMapping("/ogretmenler")
	public Ogretmen addOgretmen(@RequestBody Ogretmen ogretmen) {
		
		ogretmenService.saveTeacher(ogretmen);
		
		return ogretmen;
	}
	
	
	@PutMapping("/ogretmenler")
	public Ogretmen updateOgretmen(@RequestBody Ogretmen ogretmen) {
		
		ogretmenService.saveTeacher(ogretmen);
		
		return ogretmen;
	}
	
	
	@DeleteMapping("/ogretmenler/{ogretmenId}")
	public String deleteOgretmen(@PathVariable int ogretmenId) {
		
		ogretmenService.deleteTeacher(ogretmenId);
		
		return "Deleted ogretmen " + ogretmenId;
	}
	
	
	

}
