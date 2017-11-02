package com.wat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

/**
 * 自定义 feign 使用的注解 
 * 
 *feign 默认是支持springMVC 注解，当然我们可以通过配置使用feign自身所提供的注解
 *
 * @author chuang
 *
 */

@Configuration
public class Configuration1 {
	    @Bean
	    public Contract feignContract() {
	    	 
	        return new feign.Contract.Default();
	    }
}
