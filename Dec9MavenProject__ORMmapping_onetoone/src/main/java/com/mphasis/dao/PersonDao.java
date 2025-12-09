package com.mphasis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mphasis.entities.Passport;
import com.mphasis.entities.Person;
import com.mphasis.util.HibernateUtil;



public class PersonDao implements PersonDaoInterface{
	private static final Logger logger=LoggerFactory.getLogger(PersonDao.class);

	@Override
	public List<Person> findAll() {
		Session session=HibernateUtil.buildSessionFactory().openSession();
		logger.info("Fetching all persons details");
		List<Person>personList=session.createQuery("From Person", Person.class).list();
		session.close();
		return personList;
	}

	@Override
	public void addPerson(Person person) {
		Session session=HibernateUtil.buildSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(person);
		tx.commit();
		logger.info("person record added successfully");
		session.close();
		
		
	}

	@Override
	public Person findById(Long id) {
		Session session=HibernateUtil.buildSessionFactory().openSession();
	
		Person p=session.get(Person.class, id);
	
		session.close();
		logger.info("Person details with id {}, {}",id,p);
		return p;
	}

	@Override
	public Person findByPersonIdWithPassportDetails(Long id) {
		
		return null;
	}

}
