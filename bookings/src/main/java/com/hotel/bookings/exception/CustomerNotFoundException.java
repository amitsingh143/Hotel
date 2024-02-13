package com.hotel.bookings.exception;

import java.util.HashMap;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException() {
		super("Employee not found");
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}
	//customer vlaidation
	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handleEmployeeNotFoundException(CustomerNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
	
	//to show the default message 
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidExcep(MethodArgumentNotValidException ex) {

			Map<String, String> resp = new HashMap<>();
			ex.getBindingResult().getAllErrors().forEach((error) -> {
				String fieldName = ((FieldError) error).getField();
				String message = error.getDefaultMessage();
				resp.put(fieldName, message);
			});

			return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);

		}

}
