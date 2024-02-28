package com.spring.client1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Client1Configuration {

	@Bean
	public RestTemplate restTemplate() {

		return new RestTemplate();
	}

}
