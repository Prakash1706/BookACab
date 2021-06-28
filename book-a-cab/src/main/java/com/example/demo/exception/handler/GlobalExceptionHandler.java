package com.example.demo.exception.handler;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public ErrorDetails exceptionHandling(Exception ex, WebRequest request) {
		
		return new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		
	}

}
