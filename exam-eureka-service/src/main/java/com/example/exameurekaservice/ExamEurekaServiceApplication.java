package com.example.exameurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ExamEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamEurekaServiceApplication.class, args);
	}

}
