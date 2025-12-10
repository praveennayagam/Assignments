package com.mphasis.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Employee {
	@Value("${Employee.eid}")
	private int eid;
	@Value("${Employee.ename}")
	private String ename;
	@Autowired
	private Department dept;
	
	
//	public Employee(int eid, String ename, Department dept) {
//		super();
//		this.eid = eid;
//		this.ename = ename;
//		this.dept = dept;
//	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", dept=" + dept + "]";
	}
	
	
}
