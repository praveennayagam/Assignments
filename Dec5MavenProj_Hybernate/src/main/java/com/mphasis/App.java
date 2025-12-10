package com.mphasis;

import org.hibernate.cfg.Configuration;

import com.mphasis.model.Course;
import com.mphasis.model.Student;

import org.hibernate.SessionFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class App {
	public static void main(String[] args) {
        
    	Configuration cfg= new Configuration().configure();
    	
    	SessionFactory factory=cfg.buildSessionFactory();
    	Session session=factory.openSession();
   	Transaction tx=session.beginTransaction();
//    	Student s=new Student(128,"barath","java","5909625715","barath@gmal.com");
//    	session.save(s);
//   	tx.commit();
    	Student s=session.get(Student.class,2);
    	System.out.println(s);
    	Student s1=session.get(Student.class,2);
    	if(s==s1)
    		System.out.println("s1 reterived from session cache");
    	else
    		System.out.println("both ar diff obj");
    	
    	//get all students     
//    	List<Student> studentList=session.createQuery("From Student",Student.class).list();
//    	for(Student s1: studentList)
//    		System.out.println(s1);
//    	
    	//update student
//    	Student s=session.get(Student.class, 3);
//    	if(s!=null)
//    	{
//    		s.setMobile("898989898989");
//    		s.setStudName("Praveennayagam");
//    		s.setEmail("praveennayagam@gmail.com");
//    		s.setCourse("spring");
//    	}
//    	else
//    		System.out.println("no student with this id");
//    	
//    	session.update(s);
//    	tx.commit();
    	
    	
    	//delete
    	
//    	Student s=session.get(Student.class, 3);
//    	if(s!=null) {
//    	session.delete(s);
//    	System.out.println("student deleted");
//    	}	
//    	else
//    		System.out.println("no student found!!");
//    	
//    	tx.commit();
    	
//    	
//    	Course c=new Course(1,"java",250000);
//    	session.save(c);
//    	System.out.println("course inserted successfully");
//    	tx.commit();
//    	
//    	List<Course> courseList=session.createQuery("From Course",Course.class).list();
//    	for(Course c1: courseList)
//    		System.out.println(c1);
//    	
//    	session.close();
//    	factory.close();
//    	System.out.println("record add successfully");
    	
    }
}
