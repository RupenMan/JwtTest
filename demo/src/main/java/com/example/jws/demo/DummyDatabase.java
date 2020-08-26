package com.example.jws.demo;

import java.util.HashMap;
import java.util.Map;

import com.example.jws.demo.model.JwtPayload;

public class DummyDatabase {
	private static Map<String, JwtPayload> dataMap = new HashMap<>();
	
	public static void save(JwtPayload payload) {
		dataMap.put(payload.getName(), payload);
	}
	
	public static JwtPayload retrieve(String name) {
		return dataMap.get(name);
	}
}
