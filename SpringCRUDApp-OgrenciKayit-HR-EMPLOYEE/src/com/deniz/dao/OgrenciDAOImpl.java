package com.deniz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.deniz.entity.Ogrenci;

//@Component
@Repository
public class OgrenciDAOImpl implements OgrenciDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	
	@Override
	public List<Ogrenci> getOgrenciler() {
		
		Session session=sessionFactory.getCurrentSession();
		
	//	session.beginTransaction();
		
		Query<Ogrenci> query=session.createQuery("from Ogrenci where isDelete=1",Ogrenci.class);
		
		List<Ogrenci> resultList=query.getResultList();
		
	//	session.getTransaction().commit();
		
		
		return resultList;
	}

	
	@Override
	public void saveOgrenci(Ogrenci ogr) {
		
		Session session=sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(ogr);
		
	}


	@Override
	public Ogrenci getOgrenci(int ogrId) {
		
		Session session=sessionFactory.getCurrentSession();
		Ogrenci ogr=session.get(Ogrenci.class, ogrId);
		
		return  ogr;
	}


	@Override
	public void deleteOgrenci(int ogrId) {
		
		Session session=sessionFactory.getCurrentSession();
		
	/*	Ogrenci ogr=session.get(Ogrenci.class, ogrId);
		
		session.delete(ogr);  */
		
		session.createQuery("update Ogrenci set isDelete=0 where id="+ogrId).executeUpdate();
		
		
	}

}
