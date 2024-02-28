package com.microservices.employeeservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeAppConfiguration {

	
	@Value("${addressservice.base.url}") 
	private String addressUrl;
	
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}

	@Bean
	public WebClient webClient() {
		
		return WebClient.builder().baseUrl(addressUrl).build();
	}

	
}
