package com.mphasis.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mphasis.dao.ItemDao;
import com.mphasis.entities.Item;
import com.mphasis.exceptions.ItemNotFoundException;



@Service
public class ItemService implements ItemServiceInterface {

	@Autowired
	ItemDao dao;

	@Override
	public List<Item> findAll() {
		
		return dao.findAll();
	}

	@Override
	public Item findById(Long id) {
		
		return dao.findById(id)
				.orElseThrow(()->new ItemNotFoundException("No item present with this id "+id));
	}

	@Override
	@Transactional
	public Item save(Item item) {
		
		return dao.save(item);
	}

	@Override
	@Transactional
	public Item update(Item item, Long id) {
		Item exItem=dao.findById(id).orElseThrow(()->new ItemNotFoundException("No item present with this id "+id));
		
			exItem.setItemName(item.getItemName());
			exItem.setItemCost(item.getItemCost());
			return dao.update(exItem);

		
			
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Item exItem=dao.findById(id).orElseThrow(()->new ItemNotFoundException("No item present with this id "+id));
			dao.delte(id);
		
		
	}

}
