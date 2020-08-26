package com.example.jws.demo.model;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private String code;
	private String errorMessage;
	private String developerText;
	
	public ErrorResponse(String code, String errorMessage, String developerText) {
		this.code = code;
		this.errorMessage = errorMessage;
		this.developerText = developerText;
	}
}
