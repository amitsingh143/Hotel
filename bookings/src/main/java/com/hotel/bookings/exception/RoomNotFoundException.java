package com.hotel.bookings.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RoomNotFoundException extends RuntimeException {

	public RoomNotFoundException() {
		super("Room not found");
	}

	public RoomNotFoundException(String message) {
		super(message);
	}
}
