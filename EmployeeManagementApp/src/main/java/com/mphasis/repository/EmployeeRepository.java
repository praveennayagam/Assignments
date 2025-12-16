package com.mphasis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mphasis.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEname(String name);

	List<Employee> findBySalary(double salary);
	
	
	@Query(value="Select * from Employee where salary =?1 and ename like ?2",nativeQuery = true)
	List<Employee> findEmployeeBySalaryAndNameStartsWithS(@Param("salary") double salary,  @Param("name")String name);
	
	@Query("select e from Employee e where e.salary = :salary and e.ename like :name")
	List<Employee> findBySalaryAndName(@Param("salary") double salary, @Param("name") String name);

	
	@Query(name="findByEmployeeName")
	Employee findByEmployeeName(@Param("name") String name);

}
