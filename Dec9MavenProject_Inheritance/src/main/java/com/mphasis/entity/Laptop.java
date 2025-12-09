package com.mphasis.entity;

import jakarta.persistence.Entity;

@Entity
public class Laptop extends Product {
	
	private String brand;
	private double cost;
	public Laptop() {
		super();
	}
	public Laptop(String brand, double cost) {
		super();
		this.brand = brand;
		this.cost = cost;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Laptop [brand=" + brand + ", cost=" + cost + "]";
	}
	
	
}
