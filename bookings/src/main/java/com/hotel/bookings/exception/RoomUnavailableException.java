package com.hotel.bookings.exception;

import java.io.Serializable;

public class RoomUnavailableException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

	public RoomUnavailableException() {
		super("room is  not available");
	}

	public RoomUnavailableException(String message) {
		super(message);
	}

}

