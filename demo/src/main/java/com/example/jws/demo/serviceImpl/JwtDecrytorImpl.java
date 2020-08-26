package com.example.jws.demo.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.jws.demo.exception.UnauthorizedException;
import com.example.jws.demo.model.JwtPayload;
import com.example.jws.demo.service.JwtDecryptor;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

@Service
public class JwtDecrytorImpl implements JwtDecryptor {

	@Override
	public JwtPayload decrypt(String token) throws UnauthorizedException {
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token);
		} catch (Exception ex) {
			throw new UnauthorizedException();
		}
		ObjectMapper obj = new ObjectMapper();
		return obj.convertValue(claims.getBody(), JwtPayload.class);
	}

}
