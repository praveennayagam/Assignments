package com.mphasis.bean;

public class Address {
	
	private int addId;
	private String city;
	private String state;
	public Address() {
		super();
	}
	public Address(int addId, String city, String state) {
		super();
		this.addId = addId;
		this.city = city;
		this.state = state;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [addId=" + addId + ", city=" + city + ", state=" + state + "]";
	}
	
	
}
