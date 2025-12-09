package com.mphasis.entity;

import jakarta.persistence.Entity;

@Entity
public class IndianFood extends Food {

	private String type;

	
	public IndianFood() {
		super();
	}


	public IndianFood(String type) {
		super();
		this.type = type;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "IndianFood [type=" + type + "]";
	}
	
}
