package com.wat.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.wat.cloud.annoation.ExcludeAnnoationFliter;

/**
 * 自定义负载均衡策略
 * 
 * 如果此文件路径在 和主函数在同一目录下，则此策略影响所有的请求
 * 
 * 如果想要放在此位置，又不影响整体的，需要在启动类中过滤掉(参看启动类)
 * 
 */
@Configuration
@ExcludeAnnoationFliter
public class TestConfiguration2 {
	
	@Autowired
	IClientConfig config;
	
	@Bean
	public IRule ribbonRule(IClientConfig config) {
		return new RandomRule();
	}
	
	
}
