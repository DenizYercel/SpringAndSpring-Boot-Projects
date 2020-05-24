package com.deniz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deniz.entity.Ogrenci;
import com.deniz.entity.Ogretmen;

@Repository
public class OgretmenDAOImpl implements OgretmenDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public List<Ogretmen> getTeachers() {
		Session session=sessionFactory.getCurrentSession();
		
		//	session.beginTransaction();
			
			Query<Ogretmen> query=session.createQuery("from Ogretmen where isDelete=1",Ogretmen.class);
			
			List<Ogretmen> resultList=query.getResultList();
			
		//	session.getTransaction().commit();
			
			
			return resultList;
	}

	@Override
	public void saveTeacher(Ogretmen ogretmen) {
		
		Session session=sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(ogretmen);
		
		
	}

	@Override
	public Ogretmen getTeacher(int ogretmenId) {
		
		
		Session session=sessionFactory.getCurrentSession();
		Ogretmen ogretmen=session.get(Ogretmen.class, ogretmenId);
		
		return  ogretmen;
		
	}

	@Override
	public void deleteTeacher(int ogretmenId) {
		
		Session session=sessionFactory.getCurrentSession();
		
		/*	Ogrenci ogr=session.get(Ogrenci.class, ogrId);
			
			session.delete(ogr);  */
			
			session.createQuery("update Ogretmen set isDelete=0 where id="+ogretmenId).executeUpdate();
		
	}

}
