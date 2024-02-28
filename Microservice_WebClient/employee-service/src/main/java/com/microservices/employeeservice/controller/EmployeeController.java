package com.microservices.employeeservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.employeeservice.entity.Employee;
import com.microservices.employeeservice.repository.EmployeeRepository;
import com.microservices.employeeservice.response.AddressResponse;
import com.microservices.employeeservice.response.EmployeeResponse;
import com.microservices.employeeservice.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("getEmployeedetailsByModelMapperId/{id}")
	public EmployeeResponse getEmployeedetailsByMapperId(@PathVariable("id") int id) {

		EmployeeResponse empResponse = empService.getEmployeedetailsUseModelMapperById(id);

		return empResponse;

	}
	

}
