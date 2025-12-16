package com.mphasis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.dto.OrderDto;
import com.mphasis.entities.Orders;
import com.mphasis.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService service;
	@GetMapping("/")
	public ResponseEntity<List<Orders>> findAll()
	{
		return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Orders> findById(@PathVariable Long id)
	{
		return new ResponseEntity<>(service.findById(id),HttpStatus.FOUND);
		
	}
	
	
	@PostMapping("/")
	public ResponseEntity<Orders> save(@Valid @RequestBody OrderDto orderDto)
	{
		Orders order =new Orders();
		order.setCustomerName(orderDto.getCustomerName());
		order.setOrdDate(orderDto.getOrdDate());
		return new ResponseEntity<>(service.save(order, orderDto.getItemIds()),HttpStatus.CREATED);
		
		
	}
}
