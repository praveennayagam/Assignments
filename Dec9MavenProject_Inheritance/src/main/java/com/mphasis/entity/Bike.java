package com.mphasis.entity;

import jakarta.persistence.Entity;

@Entity
public class Bike extends Vehicle{

	private String bikeBrand;
	private double cost;
	public Bike() {
		super();
	}
	public Bike(String bikeBrand, double cost) {
		super();
		this.bikeBrand = bikeBrand;
		this.cost = cost;
	}
	public String getBikeBrand() {
		return bikeBrand;
	}
	public void setBikeBrand(String bikeBrand) {
		this.bikeBrand = bikeBrand;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Bike [bikeBrand=" + bikeBrand + ", cost=" + cost + "]";
	}
	
	
}
