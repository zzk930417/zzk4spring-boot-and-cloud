package com.test.eurekaClient.feignInter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "eureka-domain",fallback= EurekaFeignClientFallBack.class,configuration = FeignConfig.class)
public interface EurekaFeignClient {
	
	@GetMapping("/eureka-domain/test/getname")
	String getName(@RequestParam("name")String name);
}
