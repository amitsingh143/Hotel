package com.hotel.bookings.exception;

public class RoomUnavailableException extends RuntimeException {

	public RoomUnavailableException() {
		super("room is  not available");
	}

	public RoomUnavailableException(String message) {
		super(message);
	}

}

