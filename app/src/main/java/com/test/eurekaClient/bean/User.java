package com.test.eurekaClient.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private String code;
	
	private String name;
	
	private String address;
	
}
