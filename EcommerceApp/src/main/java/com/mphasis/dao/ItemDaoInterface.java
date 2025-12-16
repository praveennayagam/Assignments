package com.mphasis.dao;

import java.util.List;
import java.util.Optional;

import com.mphasis.entities.Item;

public interface ItemDaoInterface {
	
	public List<Item> findAll();
	public Optional<Item>findById(Long id);
	public Item save(Item item);
	public Item update(Item item);
	public void delte(Long id);
	public List<Item> findItemByIds(List<Long> ids);
}
