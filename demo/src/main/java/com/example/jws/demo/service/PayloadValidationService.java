package com.example.jws.demo.service;

import com.example.jws.demo.exception.BusinessException;

public interface PayloadValidationService {
	public boolean validateName(String name) throws BusinessException;
	public boolean validateEmail(String email);
	public boolean validatePhone(String phone);
}
