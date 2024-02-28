package com.microservices.addressservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.addressservice.entity.Address;
import com.microservices.addressservice.repository.AddressRepository;
import com.microservices.addressservice.response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepo;

	@Autowired
	ModelMapper modelMapper;

	public AddressResponse findEmployeeAddressByEmployeeId(int empId) {

		Address a = addressRepo.findAddressByEmployeeId(empId);

		System.out.println(a);
		AddressResponse ar = modelMapper.map(a, AddressResponse.class);
		System.out.println(ar);

		return ar;
	}
}
