package com.example.jws.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jws.demo.exception.BusinessException;
import com.example.jws.demo.exception.UnauthorizedException;
import com.example.jws.demo.model.JwtPayload;
import com.example.jws.demo.service.JwtDecryptor;
import com.example.jws.demo.serviceImpl.JWSPayloadCreator;

@RestController
@RequestMapping(value = "/jws")
public class JwsController {

	@Autowired
	private JWSPayloadCreator payloadCreator;

	@Autowired
	private JwtDecryptor decryptor;

	@PostMapping(value = "/userInfo", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> jwsUserInfo(JwtPayload payload) throws BusinessException {
		return new ResponseEntity<>(payloadCreator.createJws(payload), HttpStatus.OK);
	}

	@GetMapping(value = "/decrypt")
	public ResponseEntity<JwtPayload> decrypt(@RequestHeader ("Authorization") String token) throws UnauthorizedException {
		return new ResponseEntity<JwtPayload>(decryptor.decrypt(token), HttpStatus.OK);
	}

}
