package com.wat.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SimpleConsumerUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleConsumerUserApplication.class, args);
	}
	
	/**
	 * 在 springboot version >= 1.4 以后自己不在提供 RestTemplate 而是需要自己实现一个
	 * @param builder
	 * @return
	 */
	/*@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   // Do any additional configuration here
	   return builder.build();
	}*/
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
