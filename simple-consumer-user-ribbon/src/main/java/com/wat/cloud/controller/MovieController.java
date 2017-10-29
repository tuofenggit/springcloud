package com.wat.cloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wat.cloud.entity.User;
import com.wat.config.TestConfiguration;

@RestController
@EnableEurekaClient

/**
 * 使用了自定义的负载均衡策略 
 */
@RibbonClient(name = "simple-provider-user", configuration = TestConfiguration.class)
public class MovieController {
    
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value="/movie/{id}")
	public User findById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://simple-provider-user/simple/"+id, User.class);
	}
	
}
