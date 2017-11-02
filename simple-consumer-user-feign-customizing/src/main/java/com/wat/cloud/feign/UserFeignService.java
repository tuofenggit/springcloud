package com.wat.cloud.feign;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wat.cloud.entity.User;
import com.wat.config.Configuration1;

@FeignClient(name="simple-provider-user",configuration = Configuration1.class)
public interface UserFeignService {
	
	// feign  不支持
	//@GetMapping("/simple/{id}")
	//@PathVariable 需要设置 value
	
	@RequestMapping(value="/simple/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public User postUser(@RequestBody User user);
	
	/**
	 *   feign 的坑，即使是get方法， 如果参数使用对象方式，那么他也会去找 post 方法
	 * @param user
	 * @return
	 */
	@RequestMapping(value="get-user", method = RequestMethod.GET)
	public User getUser(@PathVariable("username") String username,@PathVariable("name") String name );//User user); 

}
