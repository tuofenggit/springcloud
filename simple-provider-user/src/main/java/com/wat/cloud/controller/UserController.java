package com.wat.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.wat.cloud.dao.UserRepository;
import com.wat.cloud.entity.User;

@RestController
@EnableEurekaClient
// @EnableDiscoveryClient 和 @EnableEurekaClient 效果一样
public class UserController {

	// 通过eureka 实现
	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id) {
		return this.userRepository.findOne(id);
	}

	@GetMapping("/eureka-instance")
	public String serviceUrl() {
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("SIMPLE-PROVIDER-USER", false);
		return instance.getHomePageUrl();
	}

	@GetMapping("/eureka-info")
	public ServiceInstance showinfo() {
		ServiceInstance instance = this.discoveryClient.getLocalServiceInstance();
		return instance;
	}

}
