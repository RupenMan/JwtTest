package com.example.jws.demo.serviceImpl;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jws.demo.exception.BusinessException;
import com.example.jws.demo.model.JwtPayload;
import com.example.jws.demo.service.PayloadValidationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwsPayloadCreatorImpl implements JWSPayloadCreator {

	@Autowired
	private PayloadValidationService validatePayload;

	@Override
	public String createJws(JwtPayload payload) throws BusinessException {
		validatePayload.validateName(payload.getName());
		validatePayload.validateEmail(payload.getEmail());
		return createJwt(payload);
	}

	@SuppressWarnings("unchecked")
	private String createJwt(JwtPayload payload) {
		Instant now = Instant.now();
		ObjectMapper obj = new ObjectMapper();
		Map<String, Object> mappedObj = obj.convertValue(payload, Map.class);
		String jwtPayload = Jwts.builder().setIssuer("rupenman").setAudience("rupenman").setIssuedAt(Date.from(now))
				.setExpiration(Date.from(now.plus(-1, ChronoUnit.MINUTES))).setClaims(mappedObj)
				.signWith(SignatureAlgorithm.HS256, "secret").compact();
		return jwtPayload;
	}

}
