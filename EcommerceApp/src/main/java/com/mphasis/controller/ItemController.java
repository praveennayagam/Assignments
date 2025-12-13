package com.mphasis.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.entities.Item;
import com.mphasis.service.ItemService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Item>>  findAll()
	{
		 
		 return  new ResponseEntity<>(service.findAll(),HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> findById(@PathVariable  Long id)
	{
		if(id<=0)
			throw new IllegalArgumentException("id can't be negative");
		
		return new ResponseEntity<>(service.findById(id),HttpStatus.FOUND);
	}
	
	@PostMapping("/")
	public Item save(@Valid  @RequestBody Item item)
	{
		return service.save(item);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Item> update( @Valid @RequestBody Item item,@PathVariable Long id)
	{
		
		if(id<=0)
			throw new IllegalArgumentException("id can't be negative");
			
		return new ResponseEntity<>(service.update(item, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete( @PathVariable Long id)
	{
		if(id<=0)
			throw new IllegalArgumentException("id can't be negative");
		
		service.delete(id);
		return  ResponseEntity.status(HttpStatus.OK).body("Item deleted");
		
	}
}
