package com.mphasis.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

//Example inside Owner









@Entity
@Table(name = "owners")
public class Owner {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false) 
  @NotBlank 
  private String name;
  @Column(nullable = false, unique = true) 
  @Email 
  private String email;
  
  @Column(nullable = false) 
  @Pattern(regexp = "^[0-9]{10}$")
  private String mobile;
  @Column(nullable = false) 
  @Min(18) 
  private Integer age; // must be >= 18

  @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PgPlace> places = new ArrayList<>();

public Owner() {
	super();
}

public Owner(Long id, String name, String email, String mobile, Integer age, List<PgPlace> places) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.mobile = mobile;
	this.age = age;
	this.places = places;
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

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public Integer getAge() {
	return age;
}

public void setAge(Integer age) {
	this.age = age;
}

public List<PgPlace> getPlaces() {
	return places;
}

public void setPlaces(List<PgPlace> places) {
	this.places = places;
}

@Override
public String toString() {
	return "Owner [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", age=" + age + "]";
}

 
}

