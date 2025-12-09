package com.mphasis.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mphasis.entities.Department;
import com.mphasis.util.HibernateUtil;

public class DepartmentDao implements DepartmentDaoInterface{
	
	public List<Department> findAll(){
		Session session = HibernateUtil.buildSessionFactory().openSession(); 
			return session.createQuery("From Department",Department.class).list();		
					
		
	}
	
	public void addDepartment(Department department) {
	
		Session session = HibernateUtil.buildSessionFactory().openSession();
		Transaction	tx=session.beginTransaction();
		session.save(department);
		tx.commit();
		session.close();
		}
	
	
	public Department findById(int id) {
			Session session = HibernateUtil.buildSessionFactory().openSession();
			return session.get(Department.class, id);	
	}
	
	public void delete(int id) {
		Session session = HibernateUtil.buildSessionFactory().openSession();
		Transaction	tx=session.beginTransaction();
		Department dept=session.get(Department.class, id);
		if(dept!=null) 
			session.delete(dept);
			tx.commit();
			System.out.println("deleted successfully");
			session.close();
		
		
	}
}
