package com.test.eurekaClient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)// 设置随机端口
@Slf4j
public class EurekaClientApplicationTests {

	@Autowired
	private TestRestTemplate RestTemplate;
	
	@Test
	public void contextLoads() {
		/*String name = RestTemplate.getForObject("/test/getname?name=张振琨", String.class);
		System.out.println("&&&&&&&&&&&&&&&&&&"+name);
		Assert.assertNotNull("get测试返回结果集", name);*/
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "张振琨");
		JSONObject result = RestTemplate.postForObject("/test/dealData", jsonObject, JSONObject.class);
		log.info(result.toString());
	}
	
	
	
	@Bean
	public TestRestTemplate getTestRestTemplate(){
		return new TestRestTemplate();
	}
	
}
