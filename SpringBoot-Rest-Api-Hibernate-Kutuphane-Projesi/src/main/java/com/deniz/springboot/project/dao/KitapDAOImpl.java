package com.deniz.springboot.project.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deniz.springboot.project.entity.Kitap;
import com.deniz.springboot.project.entity.Ogrenci;



@Repository
public class KitapDAOImpl implements KitapDAO{

	// define field for entitymanager
	
	private EntityManager entityManager;
	
	// set up constructor injection
	
	@Autowired
	public KitapDAOImpl(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}

	@Override
	public List<Kitap> getKitaplar() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Kitap> query = session.createQuery("from Kitap ORDER BY kitapAdi", Kitap.class);
		List<Kitap> resultList = query.getResultList();
		return resultList;
		
	}

	@Override
	public void saveKitap(Kitap ktp) {
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(ktp);
		
	}

	@Override
	public Kitap getKitap(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		return session.get(Kitap.class, id);
	}

	@Override
	public Ogrenci getOgrenci(int indeks) {
		Session session = entityManager.unwrap(Session.class);
		
		return session.get(Ogrenci.class, indeks);
		
	}
	
	
	

}
