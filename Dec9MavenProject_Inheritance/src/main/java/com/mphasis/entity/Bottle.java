package com.mphasis.entity;

import jakarta.persistence.Entity;

@Entity
public class Bottle extends Product{
	
	private String brand;
	private double bottlecost;
	private double capacity;
	public Bottle() {
		super();
	}
	public Bottle(String brand, double bottlecost, double capacity) {
		super();
		this.brand = brand;
		this.bottlecost = bottlecost;
		this.capacity = capacity;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getBottlecost() {
		return bottlecost;
	}
	public void setBottlecost(double bottlecost) {
		this.bottlecost = bottlecost;
	}
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "Bottle [brand=" + brand + ", bottlecost=" + bottlecost + ", capacity=" + capacity + "]";
	}
	
}
