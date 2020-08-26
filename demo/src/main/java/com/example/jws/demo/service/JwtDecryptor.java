package com.example.jws.demo.service;

import com.example.jws.demo.exception.UnauthorizedException;
import com.example.jws.demo.model.JwtPayload;

public interface JwtDecryptor {
	public JwtPayload decrypt(String token) throws UnauthorizedException;
}
