package com.mphasis;

import java.util.List;

import com.mphasis.dao.EmployeeDao;
import com.mphasis.model.Employee;

public class App {
    public static void main(String[] args) {
    	EmployeeDao dao= new EmployeeDao();
    	//dao.addEmployee(new Employee(125,"barath",70000,"testing"," tester"));
    	dao.findAll().forEach(System.out::println);
    	//dao.updateEmployee();
    	//dao.findByDept("training").forEach(System.out::println);
    	List<Employee>empl=dao.findByFilters(null, null, 50000);
    	empl.forEach(System.out::println);
    }
}
