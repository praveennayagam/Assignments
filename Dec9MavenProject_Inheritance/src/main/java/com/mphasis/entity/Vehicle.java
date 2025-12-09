package com.mphasis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {
	@Id
	private String id;
	private String type;
	public Vehicle(String id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public Vehicle() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", type=" + type + "]";
	}
	
	
}
