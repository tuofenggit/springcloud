package com.wat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 如果此文件路径在 @SpringBootApplication 或者 @ComponentScan 下将会影响所有的配置，所以要放在外面
 * 
 */
@Configuration
public class TestConfiguration {
	
	@Autowired
	IClientConfig config;
	
	@Bean
	public IRule ribbonRule(IClientConfig config) {
	 
		return new RandomRule();
	
	}
	
	
}
