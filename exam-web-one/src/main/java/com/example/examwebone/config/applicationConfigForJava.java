package com.example.examwebone.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: applicationConfigForJava
 * @Author: lingduyelang
 * @Date: 2020-11-30 11:11
 **/
@SpringBootConfiguration
public class applicationConfigForJava {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
