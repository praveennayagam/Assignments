package com.mphasis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tenants")
public class Tenant {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false) private String name;
  @Column(nullable = false, unique = true) private String email;
  @Column(nullable = false) private Integer age; // must be >= 18
public Tenant() {
	super();
}
public Tenant(Long id, String name, String email, Integer age) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.age = age;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
@Override
public String toString() {
	return "Tenant [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + "]";
}

  
}
