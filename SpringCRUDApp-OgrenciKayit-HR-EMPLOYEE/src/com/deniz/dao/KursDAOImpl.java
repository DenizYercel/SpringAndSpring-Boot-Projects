package com.deniz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deniz.entity.Employee;
import com.deniz.entity.Kurs;
import com.deniz.entity.Ogretmen;

@Repository
public class KursDAOImpl implements KursDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Kurs> getKurslar() {
		
		Session session=sessionFactory.getCurrentSession();
		
		Query<Kurs>  query=session.createQuery("from Kurs where isDelete=1",Kurs.class);
		
		List<Kurs> resultList=query.getResultList();
		
		return resultList;
	}

	@Override
	public void saveKurs(Kurs kurs) {
		Session session=sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(kurs);
		
	}

	@Override
	public Kurs getKurs(int kursId) {
		Session session=sessionFactory.getCurrentSession();
		
		Kurs kurs=session.get(Kurs.class, kursId);
		
		return kurs;
	}

	@Override
	public void deleteKurs(int kursId) {
		
		
	/*	Kurs kurs=session.get(Kurs.class, kursId);
		session.delete(kurs); */
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("update Kurs set isDelete=0 where id="+kursId).executeUpdate();
		
	}
	
	public  List<Ogretmen> getOgretmen(){
		
		Session session=sessionFactory.getCurrentSession();
		Query<Ogretmen> query=session.createQuery("from Ogretmen",Ogretmen.class);
		
		List<Ogretmen>  resulList=query.getResultList();
		return resulList;
	}

	@Override
	public List<Kurs> searchKurs(Kurs kurs) {
		String kriter="from Kurs where isDelete=1";
		
		if(kurs.getId()!=null)
			kriter+="and id=" +kurs.getId()+"";
		
		if(kurs.getKursAdi()!=null)
			kriter+="and kursAdi like '%"+kurs.getKursAdi()+"'";
		
		if(kurs.getSaat()!=null)
			kriter+="and saat="+ kurs.getSaat();
		
		if(kurs.getOgretmen().getOgretmenId()!=null)
			kriter+="and ogretmen="+ kurs.getOgretmen().getOgretmenId();
		
		
		Session session = sessionFactory.getCurrentSession();
		List<Kurs> searchKurs =session.createQuery(kriter, Kurs.class).getResultList();
		
		return searchKurs;
	}

}
