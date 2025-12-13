package com.mphasis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mphasis.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
