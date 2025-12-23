package com.mphasis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pg_places")
public class PgPlace {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String registrationNumber;

  @Column(nullable = false) private Double builtUpArea;
  @Column(nullable = false) private Double rentAmount;

  @ManyToOne(optional = false) private City city;
  @ManyToOne(optional = false) private Locality locality;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private AvailabilityStatus availability = AvailabilityStatus.AVAILABLE;

  @ManyToOne(optional = false)
  private Owner owner;

  @Column(nullable = false)
  private Long viewCount = 0L;

  public enum AvailabilityStatus { AVAILABLE, OCCUPIED }

public PgPlace() {
	super();
}

public PgPlace(Long id, String registrationNumber, Double builtUpArea, Double rentAmount, City city, Locality locality,
		AvailabilityStatus availability, Owner owner, Long viewCount) {
	super();
	this.id = id;
	this.registrationNumber = registrationNumber;
	this.builtUpArea = builtUpArea;
	this.rentAmount = rentAmount;
	this.city = city;
	this.locality = locality;
	this.availability = availability;
	this.owner = owner;
	this.viewCount = viewCount;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getRegistrationNumber() {
	return registrationNumber;
}

public void setRegistrationNumber(String registrationNumber) {
	this.registrationNumber = registrationNumber;
}

public Double getBuiltUpArea() {
	return builtUpArea;
}

public void setBuiltUpArea(Double builtUpArea) {
	this.builtUpArea = builtUpArea;
}

public Double getRentAmount() {
	return rentAmount;
}

public void setRentAmount(Double rentAmount) {
	this.rentAmount = rentAmount;
}

public City getCity() {
	return city;
}

public void setCity(City city) {
	this.city = city;
}

public Locality getLocality() {
	return locality;
}

public void setLocality(Locality locality) {
	this.locality = locality;
}

public AvailabilityStatus getAvailability() {
	return availability;
}

public void setAvailability(AvailabilityStatus availability) {
	this.availability = availability;
}

public Owner getOwner() {
	return owner;
}

public void setOwner(Owner owner) {
	this.owner = owner;
}

public Long getViewCount() {
	return viewCount;
}

public void setViewCount(Long viewCount) {
	this.viewCount = viewCount;
}

@Override
public String toString() {
	return "PgPlace [id=" + id + ", registrationNumber=" + registrationNumber + ", builtUpArea=" + builtUpArea
			+ ", rentAmount=" + rentAmount + ", city=" + city + ", locality=" + locality + ", availability="
			+ availability + ", owner=" + owner + ", viewCount=" + viewCount + "]";
}
  
  
}
