package com.spring.discoveryclient.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientController {
	
	
	@GetMapping("/address")
	public String getAddressById() {
		
	
		return "data";
	}

}
