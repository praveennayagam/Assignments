package com.mphasis.beans;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Order {
	@Value("${order.ordId}")
	private int ordId;
	@Value("#{T(java.time.LocalDate).parse( '${order.ordDate}')}")
	private LocalDate ordDate;
	@Value("${order.ordCost}")
	private double ordCost;
	@Value("#{'${order.itemList}'.split(',')}")
	private Set<String> itemList;
	@Value("#{'${order.customerName}'.toUpperCase()}")
	private String customerName;
	@Value("#{${order.ordCost}>5000?'Premium':'Normal'}")
	private String orderType;
	
	@Value("#{T(java.time.LocalDate).parse('${order.ordDate}').plusDays(5)}")
	private LocalDate deliveryDate;
	@Value("#{${order.ordCost}>5000?T(java.lang.Math).round( ${order.ordCost}*0.10) : 0}")
	private double discount;
	

	public Order() {
		super();
	}
	
	public Order(int ordId, LocalDate ordDate, double ordCost, Set<String> itemList, String customerName) {
		super();
		this.ordId = ordId;
		this.ordDate = ordDate;
		this.ordCost = ordCost;
		this.itemList = itemList;
		this.customerName = customerName;
	}

	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}
	public void setOrdDate(LocalDate ordDate) {
		this.ordDate = ordDate;
	}
	public void setOrdCost(double ordCost) {
		this.ordCost = ordCost;
	}
	public void setItemList(Set<String> itemList) {
		this.itemList = itemList;
	}
	
	
	public void getItems()
	{
		this.itemList.forEach(System.out::println);
	}

	
	@Override
	public String toString() {
		return "Order [ordId=" + ordId + ", ordDate=" + ordDate + ", ordCost=" + ordCost + ", itemList=" + itemList
				+ ", customerName=" + customerName + ", orderType=" + orderType + ", deliveryDate=" + deliveryDate
				+ ", discount=" + discount + "]";
	}
	
	
	
}
