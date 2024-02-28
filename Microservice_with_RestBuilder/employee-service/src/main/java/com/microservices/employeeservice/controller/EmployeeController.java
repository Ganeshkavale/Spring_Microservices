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

	@GetMapping("employeeDetailsById/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeedetailsById(@PathVariable("id") int id) {
//	public Employee getEmployeedetailsById(@PathVariable("id") int id) {		
//		/http://localhost:8089/employeeDetailsById/1
//		Employee emp = empService.getEmployeedetailsById(id);

		EmployeeResponse empResponse = empService.getEmployeedetailsById(id);

//	 return emp;
//		return empResponse;
//		return 	ResponseEntity.status(HttpStatus.OK).body(empResponse);+
		return ResponseEntity.status(HttpStatus.CREATED).body(empResponse);

	}

	// OR we use here Repo and ModelMapper

	// For getting details we can use model mapper so that we don't need to set
	// attributes inside the response as we have done above in the service;

	@Autowired
	EmployeeRepository empRepo;

//	@Autowired
//	RestTemplate restTemplate;
	//create RestTemplate inside configuration of EmployeeAppConfiguration

	@GetMapping("getEmployeedetailsByModelMapperId/{id}")
	public EmployeeResponse getEmployeedetailsByMapperId(@PathVariable("id") int id) {
//		http://localhost:8089/getEmployeedetailsByModelMapperId/1

		String rootURL = "http://localhost:8071/address-app/api/address/{id}";
//		AddressResponse addressResponse = restTemplate.getForObject(rootURL, AddressResponse.class, id);
//uncomment above to use RestTemplate
		// Learnt about how to use ModelMapper
		EmployeeResponse empResponse = empService.getEmployeedetailsUseModelMapperById(id);

//		empResponse.setAddressResponse(addressResponse);
		//uncomment above to use RestTemplate
		return empResponse;

	}

	@GetMapping("getEmployeeDetailsUseRestInServiceByMapperId/{id}")
	public EmployeeResponse getEmployeeDetailsUseRestInServiceByMapperId(@PathVariable("id") int id) {
//		http://localhost:8078/getEmployeeDetailsUseRestInServiceByMapperId/1

		EmployeeResponse empResponse = empService.getEmployeedetailsUseRestInServiceByMapperId(id);

		return empResponse;
	}
}
