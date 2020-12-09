package com.test.eurekaClient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.eurekaClient.common.UrlUtil;
import com.test.eurekaClient.feignInter.EurekaFeignClient;

@Service
public class TestService {

	@Autowired
	private RestTemplate template;
	
	@Autowired
	private EurekaFeignClient eurekaFeignClient;
	
	public String getName(HttpHeaders headers,Object... params){
		ParameterizedTypeReference<String> typeReference = new ParameterizedTypeReference<String>() {
		};
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> responseEntity = null;
		String resultParam = null;
		responseEntity = template.exchange(UrlUtil.TESTURL, HttpMethod.GET, entity, typeReference,params);
		resultParam = responseEntity.getBody();
		return resultParam;
	}
	
	/**
	 * feign 微服务通信测试用方法
	 * @param name
	 * @return
	 */
	public String getName(String name){
		return eurekaFeignClient.getName(name);
	}
	
}
