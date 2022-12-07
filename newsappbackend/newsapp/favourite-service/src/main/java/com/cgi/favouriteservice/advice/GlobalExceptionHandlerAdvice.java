package com.cgi.favouriteservice.advice;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice

public class GlobalExceptionHandlerAdvice {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public Map<String,String> handleMethod(JpaSystemException e){
		
		Map<String,String> map=new LinkedHashMap<>();
		
		map.put("msg", e.getMessage());
		return map;
	}

}
