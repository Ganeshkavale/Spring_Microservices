package com.spring.feignclientservice.feignClientController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.feignclientservice.feignClientInterface.FeignClient_1;

@RestController
@RequestMapping("/feign-client")
public class FeignClientController {
	
	
	@Autowired
	private FeignClient_1 feignClient;
	
	@GetMapping("/feign_name")
	public String getUserFromFeign() {
		
		return feignClient.getUser();
	}


}
