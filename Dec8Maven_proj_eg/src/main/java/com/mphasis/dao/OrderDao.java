package com.mphasis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mphasis.model.Orders;
import com.mphasis.utils.HibernateUtil;


public class OrderDao implements OrderDaoInterface{

	@Override
	public List<Orders> findAll() {
		Session session=HibernateUtil.buildSessionFactory().openSession();
		List<Orders>emplist=session.createNamedQuery("Orders.findAll",Orders.class).list();
		session.close();
		return emplist;
	}

	@Override
	public Orders findById(int id) {
		Session session=HibernateUtil.buildSessionFactory().openSession();
		Orders o=session.get(Orders.class,id);
		session.close();
		return o;
	}

	@Override
	public void addOrder(Orders order) {
		Session session=HibernateUtil.buildSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		System.out.println(order);
		session.save(order);
		tx.commit();
		session.close();
		
	}

	@Override
	public Orders updateOrder(Orders order, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Orders> findByCustomer(String customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> findByFilters(String status, String date, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

}
