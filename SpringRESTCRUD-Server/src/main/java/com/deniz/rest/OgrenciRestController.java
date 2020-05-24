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

import com.deniz.entity.Ogrenci;
import com.deniz.service.OgrenciService;

@RestController
@RequestMapping("/api")
public class OgrenciRestController {
	
	@Autowired
	OgrenciService ogrenciService;
	
	@GetMapping("/ogrenciler")
	public List<Ogrenci> getOgrenciler() {
		
		return ogrenciService.getOgrenciler();
		
	}
	
	@GetMapping("/ogrenciler/{ogrenciId}")
	public Ogrenci ogrenci(@PathVariable int ogrenciId) {
		
		Ogrenci ogr =ogrenciService.getOgrenci(ogrenciId);
		
		if(ogr==null) {
			throw new OgrenciNotFoundException("Ogrenci bulunamadi " +ogrenciId);
		}
		
		return ogr;
		
		
	}
	
	
	@PostMapping("/ogrenciler")
	public Ogrenci addOgrenci(@RequestBody Ogrenci ogrenci) {
		
	//	ogrenci.setId(0);
		ogrenciService.saveOgrenci(ogrenci);
		
		return  ogrenci;
	}
	
	
	@PutMapping("/ogrenciler")
	public Ogrenci updateOgrenci(@RequestBody Ogrenci ogrenci) {
		
		
		ogrenciService.saveOgrenci(ogrenci);
		
		return ogrenci;
	}
	
	@DeleteMapping("/ogrenciler/{ogrNo}")
	public String deleteOgrenci(@PathVariable int ogrNo) {
		
		
		/* Session session =sessionFactory.getCurrentSession();
		   Query query=session.createQuery("delete from Ogrenci" + "where id=:prmogrNo");
		   query.setParameter("prmogrNo",ogrNo);
		   
		   Performans icin parametre gecmek iyi oluyor
		  
		 */
		 
	
		
		Ogrenci ogr =ogrenciService.getOgrenci(ogrNo);
		
		if(ogr==null) {
			throw new OgrenciNotFoundException("Ogrenci bulunamadi " +ogrNo);
		}
		
		
		ogrenciService.deleteOgrenci(ogrNo);
		
		return "Deleted ogrenci id :" + ogrNo;
		
	}
	
	
}
