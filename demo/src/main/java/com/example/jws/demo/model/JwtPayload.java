package com.example.jws.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JwtPayload {
	
	private String name;
	private String email;
	private String phone;
	
}
