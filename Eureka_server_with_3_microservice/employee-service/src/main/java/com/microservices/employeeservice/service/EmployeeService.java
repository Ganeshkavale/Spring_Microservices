package com.microservices.employeeservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.employeeservice.entity.Employee;
import com.microservices.employeeservice.repository.EmployeeRepository;
import com.microservices.employeeservice.response.EmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	public EmployeeResponse getEmployeedetailsById(int id) {

		Employee emp = empRepo.findById(id).get();

		EmployeeResponse empResponse = new EmployeeResponse();

		empResponse.setId(emp.getId());
		empResponse.setName(emp.getName());

		empResponse.setEmail(emp.getEmail());
		empResponse.setBloodGroup(emp.getBloodGroup());

		
		return empResponse;

	}
	
	//using ModelMapper

	private final ModelMapper modelMapper;

	@Autowired
	public EmployeeService(ModelMapper modelMapper) {
		// TODO Auto-generated constructor stub

		this.modelMapper = modelMapper;
	}

	public EmployeeResponse getEmployeedetailsUseModelMapperById(int id) {

		Employee emp = empRepo.findById(id).get();

		 return modelMapper.map(emp, EmployeeResponse.class);	

	}

}
