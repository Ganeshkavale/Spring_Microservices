package com.microservices.addressservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.addressservice.response.AddressResponse;
import com.microservices.addressservice.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	
	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressResponse> getAddressById(@PathVariable("employeeId") int id) {
		
		System.out.println(id);
		AddressResponse addressResponse = addressService.findEmployeeAddressByEmployeeId(id);;
		
		System.out.println(addressResponse);
		if(addressResponse.equals(null)) {
			return null;
		}
		return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
	}

}
