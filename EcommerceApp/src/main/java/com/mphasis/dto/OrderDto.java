package com.mphasis.dto;

import java.time.LocalDate;
import java.util.List;

public class OrderDto {

	private LocalDate ordDate;
	private String customerName;
	private List<Long> itemIds;
	public OrderDto() {
		super();
	}
	public OrderDto(LocalDate ordDate, String customerName, List<Long> itemIds) {
		super();
		this.ordDate = ordDate;
		this.customerName = customerName;
		this.itemIds = itemIds;
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
	public List<Long> getItemIds() {
		return itemIds;
	}
	public void setItemIds(List<Long> itemIds) {
		this.itemIds = itemIds;
	}
	@Override
	public String toString() {
		return "OrderDto [ordDate=" + ordDate + ", customerName=" + customerName + ", itemIds=" + itemIds + "]";
	}
	
	
	
	
	
}
