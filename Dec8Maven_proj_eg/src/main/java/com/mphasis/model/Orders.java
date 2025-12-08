package com.mphasis.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
@Entity
@Table(name="Order_table")
@NamedQueries({@NamedQuery(name="Orders.findAll",query="From Orders")})
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int oid;
	private String orderName;
	private LocalDate date;
	private double cost;
	private List<String> items;
	public Orders() {
		super();
	}
	public Orders(int oid, String orderName, LocalDate date, double cost, List<String> items) {
		super();
		this.oid = oid;
		this.orderName = orderName;
		this.date = date;
		this.cost = cost;
		this.items = items;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public List<String> getItems() {
		return items;
	}
	public void setItems(List<String> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", orderName=" + orderName + ", date=" + date + ", cost=" + cost + ", items="
				+ items + "]";
	}
	
	
}
