package com.spring.client1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/check")
@RefreshScope
public class Client1ControllerHome {
	
	@Autowired
	private RestTemplate template;
	
	//adding @RefreshScope so if we get exception then we adding @Lazy in RestTemplate
	
	@Value("${configservergitclient.uri}")
	private String url;
	
	@GetMapping("/getPlan")
	public List<String> getPlan(){
		
		List<String> plans = template.getForObject(url, List.class);

		return plans;
	}
	
	@GetMapping("/getPlan1")
	public String getDetailsClient1() {
		
		return "client1";
	}
	
	
	

}
