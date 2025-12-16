package com.mphasis.dao;

import java.util.List;
import java.util.Optional;

import com.mphasis.entities.Orders;

public interface OrderDaoInterface {
	
	public List<Orders> findAll();
	public Orders save(Orders order);
	public Optional<Orders> findById(Long id);

}
