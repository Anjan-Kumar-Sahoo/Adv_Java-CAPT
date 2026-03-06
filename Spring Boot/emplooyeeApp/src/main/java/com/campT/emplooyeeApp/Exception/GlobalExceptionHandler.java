package com.campT.emplooyeeApp.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalExceptionHandler {

	@ExceptionHandler(ArithmeticException.class)
	public Map<String,String> handleArithmeticEx(ArithmeticException ex)
	{
		Map<String,String> map =  new HashMap<>();
		map.put("Error", ex.getMessage());
		return map;
	}
	@ExceptionHandler(CompanyNotFoundException.class)
	public Map<String,String> handleCompanyNotFoundException(CompanyNotFoundException ex)
	{
		Map<String,String> map =  new HashMap<>();
		map.put("Error", ex.getMessage());
		return map;
	}
	
	@ExceptionHandler (MethodArgumentNotValidException.class)
	public Map<String, String> handleMethoderror (MethodArgumentNotValidException mav){
		Map<String, String> map = new HashMap<>();
		mav.getBindingResult().getFieldErrors().forEach(error -> map.put(error.getField(), error.getDefaultMessage()));
		return map;
	}
 
	@ExceptionHandler(Exception.class)
	public Map<String, String> handleAllException(Exception ex) {
		Map<String, String> map = new HashMap<>();
		map.put("error", ex.getMessage());
		return map;
	}
}
