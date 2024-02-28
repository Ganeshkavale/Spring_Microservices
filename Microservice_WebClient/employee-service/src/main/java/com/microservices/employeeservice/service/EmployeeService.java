package com.microservices.employeeservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservices.employeeservice.entity.Employee;
import com.microservices.employeeservice.repository.EmployeeRepository;
import com.microservices.employeeservice.response.AddressResponse;
import com.microservices.employeeservice.response.EmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private WebClient webClient;

	public EmployeeResponse getEmployeedetailsUseModelMapperById(int id) {

		String url = "/address/";
		AddressResponse addressResponse = webClient
										  .get()
										  .uri(url+id)
										  .retrieve()
										  .bodyToMono(AddressResponse.class)
										  .block();

		Employee emp = empRepo.findById(id).get();
		EmployeeResponse empResponse = modelMapper.map(emp, EmployeeResponse.class);

		empResponse.setAddressResponse(addressResponse);

		System.out.println(empResponse);
		return empResponse;

	}

}
