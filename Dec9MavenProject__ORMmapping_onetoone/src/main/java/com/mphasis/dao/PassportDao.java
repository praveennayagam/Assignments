package com.mphasis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mphasis.entities.Passport;
import com.mphasis.entities.Person;
import com.mphasis.util.HibernateUtil;

public class PassportDao implements PassportDaoInterface{
	private static final Logger logger=LoggerFactory.getLogger(Passport.class);


	@Override
	public List<Passport> findAll() {
		
		Session session=HibernateUtil.buildSessionFactory().openSession();
		logger.info("Fetching all persons details");
		List<Passport>passportList=session.createQuery("From Passport", Passport.class).list();
		session.close();
		return passportList;
	}

	@Override
	public void addPassport(Passport passport) {
		Session session=HibernateUtil.buildSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.save(passport);
		tx.commit();
		logger.info("passport record added successfully");
		session.close();
		
	}

	@Override
	public Passport findById(Long id) {
	
		Session session=HibernateUtil.buildSessionFactory().openSession();
		Passport p=session.get(Passport.class, id);
		session.close();
		logger.info("Passport details with id {}, {}",id,p);
		return p;
	}

	@Override
	public Passport findByPersonId(Long pid) {
		Session session=HibernateUtil.buildSessionFactory().openSession();
		Query<Passport>q=session.createQuery("From Passport p where p.person.id=:pid",Passport.class);
		q.setParameter("pid", pid);
		Passport pass=q.getSingleResult();
		session.close();
		return pass;
		
	}

	

}
