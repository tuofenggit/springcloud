package com.wat.cloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wat.cloud.entity.User;

@RestController
@EnableEurekaClient
public class MovieController {
    
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value="/movie/{id}")
	public User findById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://localhost:8181/simple/"+id, User.class);
	}
	
}
