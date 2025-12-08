package com.mphasis.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mphasis.model.Employee;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class EmployeeDao implements EmployeeDaoInterface{

	@Override
	public List<Employee> findAll() {
		Session session=HibernateUtil.buildSessionFactory().openSession();
		List<Employee>emplist=session.createNamedQuery("Employee.findAll",Employee.class).list();
		session.close();
		return emplist;
		
	}

	@Override
	public Employee findById(int id) {
		Session session=HibernateUtil.buildSessionFactory().openSession();
		Employee e=session.get(Employee.class,id);
		session.close();
		return e;
		
	}

	@Override
	public void addEmployee(Employee employee) {
		Session session=HibernateUtil.buildSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(employee);
		tx.commit();
	
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		Session session=HibernateUtil.buildSessionFactory().openSession();
		 Transaction tx = null;
		    Employee existingEmployee = null;
		
		  
		        tx = session.beginTransaction();

		        // Load the existing employee by id
		        existingEmployee = session.get(Employee.class, id);

		        if (existingEmployee != null) {
		            // Update fields
		            existingEmployee.setEmpName(employee.getEmpName());
		            existingEmployee.setDept(employee.getDept());
		            existingEmployee.setSalary(employee.getSalary());

		            // Save changes
		            session.update(existingEmployee);
		        }

		        tx.commit();
	    	
	    	
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> findByDept(String dept) {
		Session session=HibernateUtil.buildSessionFactory().openSession();
		Query <Employee> q= session.createNamedQuery("Employee.findByDept",Employee.class);
		q.setParameter("dept", dept);
		List<Employee>emplist=q.list();
		session.close();
		return emplist;
	
		
	}

	@Override
	public List<Employee> findByFilters(String dept, String desg, double salary) {
		Session session=HibernateUtil.buildSessionFactory().openSession();
		
		CriteriaBuilder cb=session.getCriteriaBuilder();
		CriteriaQuery<Employee>cq=cb.createQuery(Employee.class);
		
		List<Predicate> predicates=new ArrayList<Predicate>();
		Root<Employee> root=cq.from(Employee.class);
		if(dept!=null && !dept.isEmpty())
			predicates.add(cb.equal(root.get("dept"),dept));
		if(desg!=null && !desg.isEmpty())
			predicates.add(cb.equal(root.get("desg"),desg));
		if(salary!=0)
			predicates.add(cb.greaterThanOrEqualTo(root.get("salary"),salary));
		
		cq.where(predicates.toArray(new Predicate[0]));
		List<Employee>emplist=session.createQuery(cq).getResultList();
			session.close();
		return emplist;
	}

}
