package com.example.demo.exception.handler;

import com.example.demo.exception.ExceptionResponse;
import com.example.demo.exception.UnsupportedMathException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	//Exceções Genéricas
	@ExceptionHandler(Exception.class)
	private final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex){
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UnsupportedMathException.class)
	private final ResponseEntity<ExceptionResponse> UnsupportedMathException(Exception ex){
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
