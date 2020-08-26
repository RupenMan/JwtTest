package com.example.jws.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.jws.demo.constants.JwtPayloadException;
import com.example.jws.demo.model.ErrorResponse;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class UnauthorizedExceptionHandler {
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<String> errorResponse(UnauthorizedException ex){
		ObjectMapper obj = new ObjectMapper();
		obj.setSerializationInclusion(Include.NON_NULL);
		ErrorResponse error = new ErrorResponse(null, JwtPayloadException.AUTHORIZATION_FAILURE, JwtPayloadException.TOKEN_FAILURE);
		try {
			return new ResponseEntity<String>(obj.writerWithDefaultPrettyPrinter().writeValueAsString(error), HttpStatus.UNAUTHORIZED);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
