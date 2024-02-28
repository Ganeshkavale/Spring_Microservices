package com.microservices.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

//	Employee getEmployeedetailsById(int id);
	
	

}
