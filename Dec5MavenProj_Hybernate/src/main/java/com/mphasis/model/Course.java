package com.mphasis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="course_table")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
	private String courseName;
	private double courseCost;
	
	
	public Course() {
		super();
	}


	public Course(int courseId, String courseName, double courseCost) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseCost = courseCost;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public double getCourseCost() {
		return courseCost;
	}


	public void setCourseCost(double courseCost) {
		this.courseCost = courseCost;
	}


	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseCost=" + courseCost + "]";
	}
	
	

}