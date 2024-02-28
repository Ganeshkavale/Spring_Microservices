package com.spring.configservergitclient.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("/getData")
	public List<String> getDeatils() {
		  
        List<String> yourList = List.of("Client1Deatils1", "Client1Deatils2", "Client1Deatils3");

       
        return yourList;
	}

}
