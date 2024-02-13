package com.hotel.bookings.service;



//import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.hotel.bookings.Dto.BookingRequest;
import com.hotel.bookings.entity.Bookings;

import com.hotel.bookings.exception.InvalidBookingException;
import com.hotel.bookings.exception.RoomUnavailableException;

public interface BookingService {

	// Bookings bookRoom(int roomId, int customerId, LocalDateTime checkInDate, LocalDateTime checkOutDate);
	
	 Bookings bookRoom(BookingRequest bookingRequest) throws RoomUnavailableException, InvalidBookingException;

	List<Bookings> searchBookings(Integer roomId, Integer customerId, Date checkInDate,
			Date checkOutDate);


	// Bookings bookRoom(Room room, Customer customer, LocalDateTime checkInDate, LocalDateTime checkOutDate) throws RoomUnavailableException;
}
