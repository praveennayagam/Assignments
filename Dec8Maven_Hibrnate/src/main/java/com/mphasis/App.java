package com.mphasis;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mphasis.model.Student;
import com.mphasis.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// INSERT
//        Student s=new Student(126,"irfan","sql");
//        session.save(s);
//        System.out.println("object added successfully");

		// retrive the data
//        List<Student>student=session.createQuery("From Student",Student.class).list();
//        for(Student s1: student)
//        	System.out.println(s1);

		// update student
//    	Student s2=session.get(Student.class, 123);
//    	if(s2!=null)
//    	{
//    		s2.setSname("Praveennayagam");
//    		s2.setCourse("spring");
//    	}
//    	else
//    		System.out.println("no student with this id");
//    	
//    	session.update(s2);

		// retrive the data
//      List<Student>student=session.createQuery("From Student",Student.class).list();
//      for(Student s1: student)
//      	System.out.println(s1);

		// delete

		Student s = session.get(Student.class, 125);
		if (s != null) {
			session.delete(s);
			System.out.println("student deleted");
		} else
			System.out.println("no student found!!");

		tx.commit();
		session.close();
		factory.close();
	}
}
