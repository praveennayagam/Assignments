package com.mphasis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mphasis.dao.PassportDao;
import com.mphasis.dao.PersonDao;
import com.mphasis.entities.Passport;
import com.mphasis.entities.Person;

public class App {
	private static final Logger logger =LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
    	logger.info("app started");
    	Passport pp=new Passport("India123");
    	logger.info("passport generated {}",pp);
    	Person person= new Person("Praveen","6281614948","praveen@gmail.com");
    	person.setPassport(pp);
    	logger.info("person pbject created successfully {}",person);
    	PersonDao dao=new PersonDao();
    	dao.addPerson(person);
    	dao.findAll().forEach(System.out::println);
    	System.out.println(dao.findById(2l));
    	PassportDao dao1=new PassportDao();
    	System.out.println(dao1.findByPersonId(452l));
    	logger.info("dao updated person status");
    	logger.info("App closed!!");
    }
}
