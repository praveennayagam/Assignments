package com.mphasis.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="dept")
public class Department {
		@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	private int did;
	private String dname;
	@OneToMany(mappedBy = "dept",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Employee> emplist=new ArrayList<>();
	public Department() {
		super();
	}
	
	public Department(String dname) {
		super();
		this.dname = dname;
	}


	public Department(int did, String dname, List<Employee> emplist) {
		super();
		this.did = did;
		this.dname = dname;
		this.emplist = emplist;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public List<Employee> getEmplist() {
		return emplist;
	}
	public void setEmplist(List<Employee> emplist) {
		this.emplist = emplist;
	}
	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", emplist=" + emplist + "]";
	}
	
	
	public void addEmployee(Employee e)
	{
		emplist.add(e);
		e.setDept(this);
	}
	
	public void removeEmployee(Employee e)
	{
		emplist.remove(e);
		e.setDept(null);
	}
	
	
}
