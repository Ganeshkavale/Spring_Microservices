package com.spring.resilience4j_serviceA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping
public class Service_A_Controller {

	@Autowired
	RestTemplate restTemplate;

	private static final String BASE_URL = "http://localhost:8082/";

	private static final String SERVICE_A = "resilience4j_serviceA";

	@GetMapping("/a")
	public String getServiceA() {

		String url = BASE_URL + "b";
		return restTemplate.getForObject(url, String.class);
	}

	// you can test by keeping BASE_URL server down.
	@GetMapping("/circuitBreaker")
	@CircuitBreaker(name = SERVICE_A, fallbackMethod = "getServiceACircuitBreakerFallBack")
	public String getServiceACircuitBreaker() {

		String url = BASE_URL + "circuitBreaker";

		return restTemplate.getForObject(url, String.class);
	}

	// you can test by keeping BASE_URL server down. we can use fallBack method to display 
	//alternative content if microservice failed
	
	int count =1;
	@GetMapping("/retry")
	@Retry(name = SERVICE_A)
	public String getServiceARetry() {

		String url = BASE_URL + "b";

		System.out.println("Count: ----------- " + count++);
		return restTemplate.getForObject(url, String.class);
	}

	public String getServiceACircuitBreakerFallBack(Exception e) {

		return "This is return from service A getServiceACircuitBreakerFallBack" + e.getMessage();
	}

}
