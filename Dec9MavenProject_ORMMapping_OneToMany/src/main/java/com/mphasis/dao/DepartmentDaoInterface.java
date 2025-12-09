package com.mphasis.dao;

import java.util.List;

import com.mphasis.entities.Department;

public interface DepartmentDaoInterface {
	
	
	public List<Department> findAll();
	public void addDepartment(Department department);
	public Department findById(int id);
}
