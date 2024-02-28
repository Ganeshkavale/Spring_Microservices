package com.spring.feignclientservice.feignClientInterface;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.cloud.openfeign.FeignClient(value="FeignClientTest",url="http://localhost:9091/user")
public interface FeignClient_1 {
	
	@GetMapping("/name")
	public String getUser();


}
