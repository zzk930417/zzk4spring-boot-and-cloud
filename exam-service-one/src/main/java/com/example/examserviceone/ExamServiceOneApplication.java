package com.example.examserviceone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ExamServiceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamServiceOneApplication.class, args);
	}

}
