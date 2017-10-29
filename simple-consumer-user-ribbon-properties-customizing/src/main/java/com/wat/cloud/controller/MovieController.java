package com.wat.cloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping(value="/movie/{id}")
	public User findById(@PathVariable Long id) {
	    
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("simple-provider-user");
		System.err.println("==="+":"+serviceInstance.getServiceId() +":" + serviceInstance.getHost() +":"+ serviceInstance.getPort());
		return  null;//this.restTemplate.getForObject("http://simple-provider-user/simple/"+id, User.class);
	}
	
}
