package com.capT.StudentMS.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloabalException {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException err) {
		return new ResponseEntity<>(err.getMessage(), HttpStatus.NOT_FOUND);
	}
}
