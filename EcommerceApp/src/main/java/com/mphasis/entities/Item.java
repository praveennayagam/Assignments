package com.mphasis.entities;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;


@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;
	@Size(min=3,message="item name must be min of 3 chars")
	private String itemName;
	@DecimalMin(value="1000" ,message="item cost must be more than 1000 ")
	private double itemCost;
	@ManyToMany(mappedBy = "itemList")
	@JsonBackReference
	private List<Orders> orderList;
	
	
	
	public Item() {
		super();
	}
	public Item(String itemName, double itemCost) {
		super();
		this.itemName = itemName;
		this.itemCost = itemCost;
	}
	
	
	public Item(@Size(min = 3, message = "item name must be min of 3 chars") String itemName,
			@DecimalMin(value = "1000", message = "item cost must be more than 1000 ") double itemCost,
			List<Orders> orderList) {
		super();
		this.itemName = itemName;
		this.itemCost = itemCost;
		this.orderList = orderList;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemCost() {
		return itemCost;
	}
	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}
	
	
	public List<Orders> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemCost=" + itemCost + ", orderList="
				+ orderList + "]";
	}
	
	
	
	

}
