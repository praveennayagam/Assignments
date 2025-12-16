package com.mphasis.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	@Size(min = 3, message = "minimum of 3 characters")
	@NotBlank(message = "UserName is mandatory")
	@Schema(description = "username",example = "Klaus",requiredMode = RequiredMode.REQUIRED)
	private String userName;
	@NotBlank(message = "Password is mandatory")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must be at least 8 characters long and include uppercase, lowercase, number, and special character (@$!%*?&).")
	@Schema(description = "password",example = "Hello@2025" ,requiredMode = RequiredMode.REQUIRED)
	private String password;
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Please enter a valid email address (e.g., user@example.com).")
	@Schema(description = "email",example = "user@example.com")
	private String email;

	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Please enter a valid 10-digit mobile number starting with 6, 7, 8, or 9.")
	@Schema(description = "mobile number",example = "9876543210")
	private String mobile;

	public User() {
		super();
	}

	public User(Long userId, String userName, String password, String email, String mobile) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}

	public User(String userName, String password, String email, String mobile) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}

}
