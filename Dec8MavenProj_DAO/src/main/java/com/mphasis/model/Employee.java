package com.mphasis.model;

import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="emp_table")
@NamedQueries({@NamedQuery(name="Employee.findAll",query="From Employee"),
	@NamedQuery(name="Employee.findByDept",query="From Employee where dept=:dept")
})
public class Employee {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int empId;
		private String empName;
		private double salary;
		private String dept;
		private String desg;
		public Employee() {
			super();
		}
		public Employee(int empId, String empName, double salary, String dept, String desg) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.salary = salary;
			this.dept = dept;
			this.desg = desg;
		}
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}
		public String getDesg() {
			return desg;
		}
		public void setDesg(String desg) {
			this.desg = desg;
		}
		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", dept=" + dept
					+ ", desg=" + desg + "]";
		}
		
		
}
