package com.hotel.bookings.exception;

import java.io.Serializable;

public class InvalidBookingException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

	
	public InvalidBookingException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
