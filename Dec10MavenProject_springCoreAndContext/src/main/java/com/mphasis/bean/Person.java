package com.mphasis.bean;

import java.util.Arrays;
import java.util.List;

public class Person {
	
	private int id;
	private String name;
	private int age;
	private Address add;
//	private List<String> langs;
	private String[] langs;


//	public Person(int id, String name, int age, Address add, List<String> langs) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.age = age;
//		this.add = add;
//		this.langs = langs;
//	}



	public Person(int id, String name, int age, Address add, String[] langs) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.add = add;
		this.langs = langs;
	}



	public Person() {
		super();
	}
	
	
	
	public Person(int id, String name, int age, Address add) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.add = add;
	}



	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", add=" + add + ", langs="
				+ Arrays.toString(langs) + "]";
	}



//	@Override
//	public String toString() {
//		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", add=" + add + "]";
//	}






	
	

}
