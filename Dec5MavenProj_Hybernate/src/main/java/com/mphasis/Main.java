package com.mphasis;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mphasis.model.Course;
import com.mphasis.model.Student;





public class Main {

	public static void main(String[] args) {

		Configuration cfg=new Configuration().configure();
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
//		Course c=new Course(1,"java",25000);
//		session.save (c);
//		Student s=new Student(2, "praveen", c,"9090909090", "praveen2gmail.com");
//		session.save(s);
		
		Course c1=session.get(Course.class,2);
		
		session.delete(c1);
		tx.commit();
		System.out.println("student inserted");
		session.close();
		sessionFactory.close();
		
	}

}
