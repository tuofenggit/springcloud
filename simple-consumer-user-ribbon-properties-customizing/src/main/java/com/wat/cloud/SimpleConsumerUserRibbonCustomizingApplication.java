package com.wat.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

import com.wat.cloud.annoation.ExcludeAnnoationFliter;

@SpringBootApplication
public class SimpleConsumerUserRibbonCustomizingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleConsumerUserRibbonCustomizingApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
