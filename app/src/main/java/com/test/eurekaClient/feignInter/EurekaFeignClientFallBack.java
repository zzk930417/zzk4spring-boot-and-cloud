package com.test.eurekaClient.feignInter;

/**
 * feign 依赖histrix做降级处理
 */
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class EurekaFeignClientFallBack implements EurekaFeignClient{

	@Override
	public String getName(@RequestParam("name")String name) {
		return "sorry, the request is timeout";
	}

}
