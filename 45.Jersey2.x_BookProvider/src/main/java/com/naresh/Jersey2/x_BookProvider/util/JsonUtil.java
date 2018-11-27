package com.naresh.Jersey2.x_BookProvider.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static ObjectMapper objectMapper=null;
	public static <T> T convertJsonToJava(Class<T> cls,String json) {
		 objectMapper= new ObjectMapper();
		T t=null;
		try {
			t=objectMapper.readValue(json,cls);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return t;
	}
	public static String convertJavaToJson(Object obj) {
		objectMapper= new ObjectMapper();
		String json=null;
		try {
			json=objectMapper.writeValueAsString(obj);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

}
