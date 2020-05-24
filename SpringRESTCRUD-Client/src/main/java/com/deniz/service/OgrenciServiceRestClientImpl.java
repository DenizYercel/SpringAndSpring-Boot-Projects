package com.deniz.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.deniz.entity.Ogrenci;


@Service
public class OgrenciServiceRestClientImpl implements OgrenciService{

	
	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
	
	
	@Autowired
	public OgrenciServiceRestClientImpl(RestTemplate restTemplate,
			                           @Value("${crm.rest.url}") String crmRestUrl) {

		this.restTemplate = restTemplate;
		this.crmRestUrl = crmRestUrl;
		
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}

	@Override
	public List<Ogrenci> getOgrenciler() {
		
		logger.info("in getOgrenci(): Calling REST API " + crmRestUrl);
		
		//make REST call
		
		ResponseEntity <List<Ogrenci>> responseEntity =
				restTemplate.exchange(crmRestUrl, HttpMethod.GET
				,null
				,new ParameterizedTypeReference<List<Ogrenci>>() {});
		
		// get the list of customers from response
				List<Ogrenci> ogrenciler = responseEntity.getBody();

				logger.info("in getOgrenci(): ogrenciler" + ogrenciler);
				
				return ogrenciler;
		
		
	}
	
	@Override
	public Ogrenci getOgrenci(int ogrId) {
		
		
		logger.info("in getOgrenci(): Calling REST API " + crmRestUrl);
		
		Ogrenci ogrenci =restTemplate.getForObject(crmRestUrl + "/" + ogrId,Ogrenci.class);
		
		logger.info("in saveogrenci(): ogrId=" + ogrId);
		
		return ogrenci;
	}

	@Override
	public void saveOgrenci(Ogrenci ogr) {
		
		logger.info("in saveogrenci(): Calling REST API " + crmRestUrl);
		
		int id=ogr.getId();
		
		// make REST call
		if(id==0) {
			
			// add ogrenci
			restTemplate.postForEntity(crmRestUrl, ogr, String.class);
		}
		else {
			// update ogrenci
			restTemplate.put(crmRestUrl, ogr);
		}
		
		logger.info("in saveogrenci(): success");
		
	}

	
	@Override
	public void deleteOgrenci(int ogrId) {
		
		logger.info("in deleteOgrenci(): Calling REST API " + crmRestUrl);

		// make REST call
		
		restTemplate.delete(crmRestUrl +"/"+ogrId);
		
		logger.info("in deleteOgrenci(): deleted ogrenci theId=" + ogrId);
		
	}
	
	

	

}
