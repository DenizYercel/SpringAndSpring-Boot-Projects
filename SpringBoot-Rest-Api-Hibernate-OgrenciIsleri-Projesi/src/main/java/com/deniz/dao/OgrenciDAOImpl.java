package com.deniz.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deniz.domain.Ogrenci;

@Repository
public class OgrenciDAOImpl implements OgrenciDAO {
		
	private EntityManager entityManager;
	
	
	@Autowired
	public OgrenciDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<Ogrenci> getOgrenciler() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Ogrenci> query = session.createQuery("from Ogrenci ORDER BY ad",Ogrenci.class);
		List<Ogrenci> resultList = query.getResultList();
		
		return resultList;
	}

	@Override
	public Ogrenci getOgrenci(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Ogrenci ogrenci = session.get(Ogrenci.class, id);
		return ogrenci;
	}

	@Override
	public void saveOgrenci(Ogrenci ogrenci) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(ogrenci);
	}

	@Override
	public Ogrenci getOgrencifromOgrNo(int ogrNo) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Ogrenci> query=session.createQuery("from Ogrenci  where ogrenciNo=:ogrNumber and " 
				+ " ogrencilikDurumu=:aktiflik",Ogrenci.class);
		
		query.setParameter("ogrNumber",ogrNo);
		query.setParameter("aktiflik", 1); //ogrenciligi aktif olanlar
		
		List<Ogrenci> resultList = query.getResultList();
		
		if(!resultList.isEmpty()) {
			return resultList.get(0);
		}
		else{
			return null;
		}
		
	}

	
}
