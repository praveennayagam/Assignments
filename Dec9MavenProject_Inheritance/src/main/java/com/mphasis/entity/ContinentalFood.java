package com.mphasis.entity;

import jakarta.persistence.Entity;

@Entity
public class ContinentalFood extends Food {

	private double price;
	private int ratings;
	
	
	public ContinentalFood() {
		super();
	}
	public ContinentalFood(double price, int ratings) {
		super();
		this.price = price;
		this.ratings = ratings;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	@Override
	public String toString() {
		return "ContinentalFood [price=" + price + ", ratings=" + ratings + "]";
	}
	
	
}
