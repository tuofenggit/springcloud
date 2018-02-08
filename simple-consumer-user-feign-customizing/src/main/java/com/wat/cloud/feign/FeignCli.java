package com.wat.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wat.config.Configuration2;

/**
 * 通过此方法验证 configuration 配置如果不在 主函数内部，不会被Spring扫描到，此配置只会影响 通过configuration=Configuration2.class)  配置的类
 * 
 * @author wangchuang
 *
 */

@FeignClient(name="xxx",url="http://localhost:8761/",configuration=Configuration2.class)
public interface FeignCli {
    
	
	@RequestMapping("/eureka/apps/{serverNmae}")
	public String findEurekaServerName(@PathVariable("serverNmae")String serverNmae);
}
