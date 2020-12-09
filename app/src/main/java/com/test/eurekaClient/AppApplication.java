package com.test.eurekaClient;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@EnableEurekaClient
@RestController
@Data
@Slf4j
@EnableFeignClients
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	@RequestMapping(value ="/",method = RequestMethod.GET)
	public ModelAndView Hello() {
		log.info("项目调用成功！");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name","你好！");
		modelAndView.setViewName("hello");
		return modelAndView;
	}
	
	/**
	 * Rest模板
	 * @return
	 */
	@Bean
	@LoadBalanced   // 注：不加不能成功连接--即不能使用resttemplate基于应用名+URI的地址 rabbon
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	

}
