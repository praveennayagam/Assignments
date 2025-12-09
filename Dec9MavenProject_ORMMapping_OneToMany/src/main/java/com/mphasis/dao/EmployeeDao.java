package com.mphasis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mphasis.entities.Employee;
import com.mphasis.util.HibernateUtil;

public class EmployeeDao implements EmployeeDaoInterface {
	
	public List<Employee> findAll(){
		Session session=HibernateUtil.buildSessionFactory().openSession();
		List<Employee>elist=session.createQuery("From Employee",Employee.class).list();
		session.close();
		return elist;
	}
	
	public void addEmployee(Employee e) {
		Session session=HibernateUtil.buildSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.save(e);
		tx.commit();
		session.close();
		System.out.println("record insterted");
	}
	
	public Employee findById(int id) {
		Session session=HibernateUtil.buildSessionFactory().openSession();
			return session.get(Employee.class, id);
		
	}
}
