package com.mphasis.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="students_table")
@NamedQueries({@NamedQuery(name="Student.findAll",query="From Student"),
@NamedQuery(name="Student.findByCourse",query="From Student where course=:course"),
@NamedQuery(name="Student.count",query="select count(*) from Student"),
@NamedQuery(name="Student.groupByCourse",query="select course,count(*) from Student group by course"),
@NamedQuery(name="Student.startsWith",query="From Student where sname like 'p%'")
})
public class Student {
	@Id
	private int sid;
	private String sname;
	private String course;
	public Student(int sid, String sname, String course) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.course = course;
	}
	public Student() {
		super();
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", course=" + course + "]";
	}
	
	

}
