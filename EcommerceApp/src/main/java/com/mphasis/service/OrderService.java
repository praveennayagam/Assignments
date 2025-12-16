package com.mphasis.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mphasis.dao.ItemDao;
import com.mphasis.dao.OrderDao;
import com.mphasis.entities.Orders;
import com.mphasis.exceptions.OrderNotFoundException;
@Service
public class OrderService implements OrderServiceInterface{
	@Autowired
	OrderDao dao;
	
	@Autowired
	ItemDao ido;

	@Override
	public List<Orders> findAll() {
	
		return dao.findAll();
	}

	@Override

	public Orders save(Orders order,List<Long> itemIds) {
		order.setItemList(ido.findItemByIds(itemIds));
		return dao.save(order);
	}

	@Override
	@Transactional
	public Orders findById(Long id) {
		
		return dao.findById(id)
				.orElseThrow(()->new OrderNotFoundException("No order present with this id "+id));
	}

}
