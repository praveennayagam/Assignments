package com.mphasis.service;

import java.util.List;

import com.mphasis.dto.ItemDto;
import com.mphasis.entities.Item;

public interface ItemServiceInterface {
	
	public List<Item> findAll();
	public Item findById(Long id);
	public Item save(ItemDto itemDto);
	public Item update(Item item,Long id);
	public void delete(Long id);

}
