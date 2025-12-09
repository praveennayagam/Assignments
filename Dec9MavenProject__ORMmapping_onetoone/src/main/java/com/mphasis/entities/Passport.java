package com.mphasis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Passport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Size(min=8,message="min of 8 length")
	private String passportNumber;
	@OneToOne
	@JoinColumn(name="person_id",referencedColumnName = "id")
	private Person person;
	public Passport() {
		super();
	}
	
	
	public Passport(@Size(min = 8, message = "min of 8 length") String passportNumber) {
		super();
		this.passportNumber = passportNumber;
	}


	public Passport(Long id, @Size(min = 8, message = "min of 8 length") String passportNumber) {
		super();
		this.id = id;
		this.passportNumber = passportNumber;
	}


	public Passport(Long id, @Size(min = 8, message = "min of 8 length") String passportNumber, Person person) {
		super();
		this.id = id;
		this.passportNumber = passportNumber;
		this.person = person;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}


	@Override
	public String toString() {
		return "Passport [id=" + id + ", passportNumber=" + passportNumber + "]";
	}
	
	
	

}
