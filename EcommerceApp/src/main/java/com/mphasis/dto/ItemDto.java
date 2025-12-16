package com.mphasis.dto;



public class ItemDto {
	
	private Long itemId;
	private String itemName;
	private double itemCost;
	public ItemDto() {
		super();
	}
	public ItemDto(Long itemId, String itemName, double itemCost) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCost = itemCost;
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
	@Override
	public String toString() {
		return "ItemDto [itemId=" + itemId + ", itemName=" + itemName + ", itemCost=" + itemCost + "]";
	}
	
	
}
