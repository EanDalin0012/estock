package com.estock.stockmanagement.util;

import java.io.IOException;
import java.util.Map;

import com.estock.stockmanagement.common.exception.CustomException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.core.io.Resource;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EUtil {
	public static final ObjectMapper objectMapper = new ObjectMapper();
	
	public static String toJSON(Object object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (IOException ex) {
			log.error("IOException: " + ex.getMessage());
			return null;
		}
	}
	
	public static JsonNode readTree(String json) throws IOException {
		return objectMapper.readTree(json);
	}

	public static JsonNode readTree(Resource resource) throws IOException {
		return objectMapper.readTree(resource.getFile());
	}
	
	public static <T> T convert(Object object, Class<T> clazz) {
		return objectMapper.convertValue(object, clazz);
	}

	public static <T> T convert(Object object, TypeReference<T> typeReference) {
		return objectMapper.convertValue(object, typeReference);
	}
	
	public static Map<String, Object> convert(Object object) {
		return objectMapper.convertValue(object, new TypeReference<Map<String, Object>>() {});
	}
	
	public static <T> T readJSON(String json, Class<T> clazz) throws CustomException {
		try {
			return objectMapper.readValue(json, clazz);
		}catch(Exception ex) {
			log.error(ex.getMessage()); 
			throw new CustomException(ex.getMessage());
		}
	}
	
	public static Map<String, Object> readJSON(String json) throws CustomException {
		try {
			return objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {});
		}catch(Exception ex) {
			log.error(ex.getMessage()); 
			throw new CustomException(ex.getMessage());
		}
	}

	public static <T> T readJSON(byte[] json, Class<T> clazz) throws CustomException {
		try {
			return objectMapper.readValue(json, clazz);
		}catch(Exception ex) {
			log.error(ex.getMessage()); 
			throw new CustomException(ex.getMessage());
		}
	}

	public static <T> T readJSON(String json, TypeReference<T> typeReference) throws CustomException {
		try {
			return objectMapper.readValue(json, typeReference);
		}catch(Exception ex) {
			log.error(ex.getMessage()); 
			throw new CustomException(ex.getMessage());
		}
	}
}
