package com.wat.cloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wat.cloud.entity.User;
import com.wat.cloud.feign.UserFeignService;

@RestController
@EnableEurekaClient
public class MovieController {
    
	@Autowired
	private UserFeignService userFeignService;
	
	@GetMapping(value="/movie/{id}")
	public User findById(@PathVariable Long id) {
		return userFeignService.findById(id);
	}
	
	@GetMapping(value="/test")
	public User testPost(User user) {
		return userFeignService.postUser(user);
	}
	
	@GetMapping(value="/test")
	public User getUser() {
		return userFeignService.getUser("", "");
	}
	
}
