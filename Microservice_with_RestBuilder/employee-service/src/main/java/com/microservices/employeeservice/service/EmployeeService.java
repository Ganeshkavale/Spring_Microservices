package com.microservices.employeeservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.employeeservice.entity.Employee;
import com.microservices.employeeservice.repository.EmployeeRepository;
import com.microservices.employeeservice.response.AddressResponse;
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

	// using ModelMapper

	@Autowired
	private ModelMapper modelMapper;

	public EmployeeResponse getEmployeedetailsUseModelMapperById(int id) {

		Employee emp = empRepo.findById(id).get();

		return modelMapper.map(emp, EmployeeResponse.class);

	}

	// rest tempate in service with model mapper

	
	RestTemplate restTemplate;
	
	@Value("${addressservice.base.url}")
	private String addressBaseUrl;
	
	
	public EmployeeService(@Value("${addressservice.base.url}")
	 String addressBaseUrl,RestTemplateBuilder builder) {
		
		// TODO Auto-generated constructor stub
		
		System.out.println(addressBaseUrl);
		this.restTemplate=builder
						  .rootUri(addressBaseUrl)
						  .build();		
	}
	
	
	
	public EmployeeResponse getEmployeedetailsUseRestInServiceByMapperId(int id) {
		// TODO Auto-generated method stub

		AddressResponse addressResponse = restTemplate.getForObject("/address/{id}", AddressResponse.class, id);

		Employee emp = empRepo.findById(id).get();

		EmployeeResponse empResponse = modelMapper.map(emp, EmployeeResponse.class);
		empResponse.setAddressResponse(addressResponse);

		return empResponse;

	}

}
