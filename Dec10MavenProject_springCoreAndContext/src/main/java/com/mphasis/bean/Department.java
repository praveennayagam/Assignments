package com.mphasis.bean;

import org.springframework.beans.factory.annotation.Value;

public class Department {
	@Value("${Department.did}")
	private int did;
	@Value("${Department.dname}")
	private String dname;
	
	public void setDid(int did) {
		this.did = did;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + "]";
	}
	
	

}
