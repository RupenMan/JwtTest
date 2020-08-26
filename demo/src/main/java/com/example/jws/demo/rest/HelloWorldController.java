package com.example.jws.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class HelloWorldController {
	
	@RequestMapping(value="/hello",method = RequestMethod.GET)
	public String hello() {
		return "Hello World";
	}
}
