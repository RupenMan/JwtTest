package com.example.jws.demo.exception;

import org.springframework.http.HttpStatus;

import com.example.jws.demo.model.ErrorResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper= false)
public class BusinessException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	private String errorCode;
	private String errorMessage;
	private String developerText;
	
	public BusinessException(HttpStatus status, ErrorResponse errorResponse) {
		super();
		this.status = status;
		this.errorCode = errorResponse.getCode();
		this.errorMessage = errorResponse.getErrorMessage();
		this.developerText = errorResponse.getDeveloperText();
	}
}
