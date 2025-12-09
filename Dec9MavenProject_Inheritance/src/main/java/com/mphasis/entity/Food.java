package com.mphasis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Food {
	@Id
	private int footId;
	private String foodName;
	public Food() {
		super();
	}
	public Food(int footId, String foodName) {
		super();
		this.footId = footId;
		this.foodName = foodName;
	}
	public int getFootId() {
		return footId;
	}
	public void setFootId(int footId) {
		this.footId = footId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	@Override
	public String toString() {
		return "Food [footId=" + footId + ", foodName=" + foodName + "]";
	}
	
}
