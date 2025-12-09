package com.mphasis.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Size(min=3,message="Person name must be min of 3 chars")
	@NotNull
	private String name;
	@Pattern(regexp="[6789][0-9]{9}",message="please enter valid mobile number, "
			+ "Mobile number must starts with either"
			+"6,7,8,or 9 with exact length of 10 digits")
	private String mobile;
	@Email
	private String email;
	
	@OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
	private Passport passport;
	public Person() {
		super();
	}
	
	
	public Person(@Size(min = 3, message = "Person name must be min of 3 chars") @NotNull String name,
			@Pattern(regexp = "[6789][0-9]{9}", message = "please enter valid mobile number, Mobile number must starts with either6,7,8,or 9 with exact length of 10 digits") String mobile,
			@Email String email) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}


	public Person(Long id, @Size(min = 3, message = "Person name must be min of 3 chars") @NotNull String name,
			@Pattern(regexp = "[6789][0-9]{9}", message = "please enter valid mobile number, Mobile number must starts with either6,7,8,or 9 with exact length of 10 digits") String mobile,
			@Email String email, Passport passport) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.passport = passport;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
		passport.setPerson(this);
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", passport="
				+ passport + "]";
	}
	
	
	
}
