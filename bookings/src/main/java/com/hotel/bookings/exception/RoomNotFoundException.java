package com.hotel.bookings.exception;

import java.io.Serializable;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RoomNotFoundException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L; 

	public RoomNotFoundException() {
		super("Room not found");
	}

	public RoomNotFoundException(String message) {
		super(message);
	}
}
