package com.microservices.employeeservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EmployeeAppConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}
	
	@Bean
	public RestTemplate restTemplateMapper() {
		
		return new RestTemplate();
	}
	
}
