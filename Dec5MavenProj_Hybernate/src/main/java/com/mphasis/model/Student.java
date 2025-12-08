package com.mphasis.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="student_table")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studId;
	private String studName;
	@OneToOne
	@JoinColumn(name="cid", referencedColumnName = "courseId",unique = true)
	private Course course;

	private String mobile;
	private String email;
	
	public Student() {
		super();
	}

	public Student(int studId, String studName, Course course, String mobile, String email) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.course = course;
		this.mobile = mobile;
		this.email = email;
	}

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", course=" + course + ", mobile=" + mobile
				+ ", email=" + email + "]";
	}
	
	
	
	
}
