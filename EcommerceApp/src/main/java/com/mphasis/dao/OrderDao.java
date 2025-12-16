package com.mphasis.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.entities.Orders;
import com.mphasis.repository.OrderRepository;

@Repository
public class OrderDao implements OrderDaoInterface{

	@Autowired
	OrderRepository repository;
	
	@Override
	public List<Orders> findAll() {
	
		return repository.findAll();
	}

	@Override
	public Orders save(Orders order) {
	
		return repository.save(order);
	}

	@Override
	public Optional<Orders> findById(Long id) {
		
		return repository.findById(id);
	}

}
