package com.mphasis.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Student {
		@Value("${Student.sid}")
	private int sid;
		@Value("${Student.sname}")
	private String sname;
//		@Autowired
//	private Course course;
		@PostConstruct
		public void onInit()
		{
			System.out.println("After bean instantiation....");
			
		}
		
		@PreDestroy
		public void onDestroy()
		{
			System.out.println("before bean destroyed....");
		}
		
		
		
		
		
		
		
	public Student() {
		super();
		System.out.println("Bean created...");
	}
	public Student(int sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
//		this.course = course;
	}
	
	
	public void setSid(int sid) {
		this.sid = sid;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
//	public void setCourse(Course course) {
//		this.course = course;
//	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname +   "]";
	}
	
	
	
}
