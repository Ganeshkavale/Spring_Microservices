package com.microservices.addressservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.microservices.addressservice.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	@Query(nativeQuery=true,value = "select a.*,e.id employeeId, e.name,e.email,e.bloodgroup from  address a inner join employee e on e.id=a.employeeId  where a.employeeId=:employeeId")
	Address findAddressByEmployeeId(@Param("employeeId") int id);
	
}
