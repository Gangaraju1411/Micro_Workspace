package com.ashokit.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //Global exception handling
public class AppExceptionHandler {

	@ExceptionHandler(value = UserNotFoundException.class)// this is responsible for to handle this UNE whereever occured in application
	public ResponseEntity<ErrorInfo> handleUserNFE(Exception e) {

		String msg = e.getMessage();

		ErrorInfo info = new ErrorInfo();
		info.setCode("SBIEX0001");
		info.setCode(msg);
		info.setWhen(LocalDate.now());

		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorInfo> handleException(Exception e) {

		String msg = e.getMessage();

		ErrorInfo info = new ErrorInfo();
		info.setCode("SBIEX0003");
		info.setCode(msg);
		info.setWhen(LocalDate.now());

		// bad request means client side mistake
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);

	}

	
	
	
	
	
	
	
	
	
	
	
}
