package com.test.eurekaClient.bean;

import lombok.Data;

@Data
public class Person {
	private String firstName, lastName, job, gender;  
	private int salary, age;  
	
	
	  
	public Person(String firstName, String lastName, String job,  
	                String gender, int age, int salary)       {  
	          this.firstName = firstName;  
	          this.lastName = lastName;  
	          this.gender = gender;  
	          this.age = age;  
	          this.job = job;  
	          this.salary = salary;  
	}



	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}  
	
}
