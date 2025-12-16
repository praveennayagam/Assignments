package com.mphasis.entities;

import java.time.LocalDate;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ordId;
	@NotNull(message="Order Date cannot be null")
	private LocalDate ordDate;
	@NotBlank(message="Customer name is mandatory")
	@Size(min=3 , message="Name must be minimum of 3 chars")
	private String customerName;
	@ManyToMany()
	@JoinTable(name="order_item",joinColumns = @JoinColumn(name="ordId"),inverseJoinColumns = @JoinColumn(name="itemId"))
	@JsonManagedReference
	private List<Item> itemList;
	public Orders() {
		super();
	}
	public Orders(LocalDate ordDate, String customerName, List<Item> itemList) {
		super();
		this.ordDate = ordDate;
		this.customerName = customerName;
		this.itemList = itemList;
	}
	public Long getOrdId() {
		return ordId;
	}
	public void setOrdId(Long ordId) {
		this.ordId = ordId;
	}
	public LocalDate getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(LocalDate ordDate) {
		this.ordDate = ordDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	@Override
	public String toString() {
		return "Orders [ordId=" + ordId + ", ordDate=" + ordDate + ", customerName=" + customerName + ", itemList="
				+ itemList + "]";
	}

	
	
}
