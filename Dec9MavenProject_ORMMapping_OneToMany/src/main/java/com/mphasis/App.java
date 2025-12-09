package com.mphasis;

import com.mphasis.dao.DepartmentDao;
import com.mphasis.dao.EmployeeDao;
import com.mphasis.entities.Department;
import com.mphasis.entities.Employee;

public class App {
    public static void main(String[] args) {
        
    	DepartmentDao deptdao=new DepartmentDao();
    	EmployeeDao empdao=new EmployeeDao();
    	
    	Department dept=new Department("IT");
    	Employee e1=new Employee("Priya");
    	Employee e2=new Employee("varun");
    	Employee e3=new Employee("Sabesh");
    	Employee e4=new Employee("bala");
    	
    	dept.addEmployee(e1);
    	dept.addEmployee(e2);
    	dept.addEmployee(e3);
    	dept.addEmployee(e4);
    	
    	//deptdao.addDepartment(dept);
    	
    	//deptdao.delete(1);
    	
    	deptdao.findAll().forEach(System.out::println);
    	
    
    	
    	
    }
}
