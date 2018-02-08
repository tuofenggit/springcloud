package com.wat.cloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wat.cloud.entity.User;

@RestController
@EnableEurekaClient

/**
 * 使用了自定义的负载均衡策略 
 */
public class MovieController {
    
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "findByIdFallback")
	@GetMapping(value="/movie/{id}")
	public User findById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://simple-provider-user/simple/"+id, User.class);
	}
	
	public User findByIdFallback(Long id) {
		User user = new User();
		user.setId(0L);
		return user;
	}
	
}
