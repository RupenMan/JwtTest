package com.example.jws.demo.serviceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.jws.demo.constants.JwtPayloadException;
import com.example.jws.demo.exception.BusinessException;
import com.example.jws.demo.model.ErrorResponse;
import com.example.jws.demo.service.PayloadValidationService;

@Service
public class PayloadValidator implements PayloadValidationService {

	@Override
	public boolean validateName(String name) throws BusinessException {
		boolean isNameValid = true;
		if (StringUtils.isEmpty(name)) {
			throw new BusinessException(HttpStatus.BAD_REQUEST,
					new ErrorResponse(JwtPayloadException.NAME_NOT_FOUND_CODE, JwtPayloadException.BAD_REQUEST,
							JwtPayloadException.EMPTY_NAME));
		}

		return isNameValid;
	}

	@Override
	public boolean validateEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validatePhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}

}
