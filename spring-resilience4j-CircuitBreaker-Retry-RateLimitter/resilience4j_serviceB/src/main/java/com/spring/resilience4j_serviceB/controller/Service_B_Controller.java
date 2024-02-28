package com.spring.resilience4j_serviceB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class Service_B_Controller {

	@GetMapping("/b")
	public String getServiceB() {

	
		return "service B from A";
	}

	@GetMapping("/circuitBreaker")
	public String getServiceBCircuitBreaker() {

		
		return "service @GetMapping(\"/circuitBreaker\")\r\n"
				+ "	public String getServiceBCircuitBreaker() {\r\n"
				+ "\r\n"
				+ "		\r\n"
				+ "		return \"service B from A\";\r\n"
				+ "	} Done";
	}

}
