package com.mphasis.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Course {
	
	@Value("${Course.courseId}")
	private int courseId;
	@Value("${Course.courseName}")
	private String courseName;
	public Course() {
		super();
	}
	public Course(int courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}
	
	
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + "]";
	}
	
	
	
}
