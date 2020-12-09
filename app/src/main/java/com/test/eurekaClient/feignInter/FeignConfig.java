package com.test.eurekaClient.feignInter;
import org.springframework.context.annotation.Bean;
/**
 * Feign配置类
 */
import org.springframework.context.annotation.Configuration;

import feign.Retryer;

@Configuration
public class FeignConfig {

	@Bean
	public Retryer feignRetryer(){
		// period=100 发起当前请求的时间间隔，单位毫秒
		// maxPeriod=1000 发起当前请求的最大时间间隔，单位毫秒
		// maxAttempts=3 最多请求次数，包括第一次
		return new Retryer.Default(100, 1000, 3);
	}
	
	
}
