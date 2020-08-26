package com.example.jws.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.jws.demo.model.ErrorResponse;

@ControllerAdvice
public class BusinessExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({BusinessException.class})
	public ResponseEntity<ErrorResponse> handleAnyException(BusinessException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage(),ex.getDeveloperText());
		return new ResponseEntity<>(errorResponse, ex.getStatus());
	}
}
