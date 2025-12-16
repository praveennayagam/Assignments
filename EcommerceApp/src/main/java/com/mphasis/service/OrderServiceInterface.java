package com.mphasis.service;

import java.util.List;


import com.mphasis.entities.Orders;

public interface OrderServiceInterface {
	
	public List<Orders> findAll();
	public Orders save(Orders order,List<Long> itemIds);
	public Orders findById(Long id)   ;

}
