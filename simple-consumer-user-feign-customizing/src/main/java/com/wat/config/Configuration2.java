package com.wat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

/**
 * 
 * 如果eureka 使用了 验证功能（开启用户密码模式） 可以同过此配置，支持调用 http://localhost:xxx/eureka/apps/xxx
 * 
 * @author wangchuang
 *
 */
@Configuration
public class Configuration2 {
	
	@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("username", "password123");
    }
	
}
