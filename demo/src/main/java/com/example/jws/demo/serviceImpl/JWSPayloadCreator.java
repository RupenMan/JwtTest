package com.example.jws.demo.serviceImpl;

import com.example.jws.demo.exception.BusinessException;
import com.example.jws.demo.model.JwtPayload;

public interface JWSPayloadCreator {
	public String createJws(JwtPayload payload) throws BusinessException;
}
