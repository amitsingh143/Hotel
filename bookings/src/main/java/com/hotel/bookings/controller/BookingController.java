package com.hotel.bookings.controller;

import java.math.BigDecimal;


//import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
//import com.hotel.bookings.config.JacksonConfi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.bookings.Dto.BookingRequest;

import com.hotel.bookings.entity.Bookings;

import com.hotel.bookings.exception.RoomUnavailableException;
import com.hotel.bookings.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;

//	@PostMapping("/book")
//	public ResponseEntity<Bookings> bookRoom(@Valid @RequestParam int roomId, @RequestParam int customerId,
//			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime checkInDate,
//			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime checkOutDate) {
//		Bookings booking = bookingService.bookRoom(roomId, customerId, checkInDate, checkOutDate);
//		return ResponseEntity.ok(booking);
//	}
	
//	 @PostMapping("/book")
//	    public ResponseEntity<String> bookRoom(@RequestBody BookingRequest bookingRequest) {
//	        try {
//	            Bookings bookedRoom = bookingService.bookRoom(bookingRequest);
//	            return ResponseEntity.ok("Room booked successfully. Booking ID: " + bookedRoom.getBookingId() +
//	                    ". Total Price: " + bookedRoom.getTotalPrice());
//	        } catch (RoomUnavailableException e) {
//	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//	        }
//	    }
	 
	 
	 @PostMapping("/book")
	    public ResponseEntity<String> bookRoom(@Valid @RequestBody BookingRequest bookingRequest) {
	        try {
	            // Book the room and retrieve the booking details
	            Bookings bookedRoom = bookingService.bookRoom(bookingRequest);
	            
	            // Include the total price in the response
	            BigDecimal totalPrice = bookedRoom.getTotalPrice();
	            
	            // Construct the response message with booking details and total price
	            String responseMessage = "Room booked successfully. Booking ID: " + bookedRoom.getBookingId() +
	                    ". Total Price: " + totalPrice;
	            
	            
	            
	            // Return the response with HTTP status OK
	            return ResponseEntity.ok(responseMessage);
	        } catch (RoomUnavailableException e) {
	            // If room is unavailable, return HTTP status 400 with error message
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	        }
	         

	    
	     
	        }
	 
	 @PostMapping("/search")
	 public ResponseEntity<List<Bookings>> searchBookings(
	         @RequestParam(name = "roomId", required = false) Integer roomId,
	         @RequestParam(name = "customerId", required = false) Integer customerId,
	         @RequestParam(name = "checkInDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkInDate,
	         @RequestParam(name = "checkOutDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkOutDate) {
	     List<Bookings> bookings = bookingService.searchBookings(roomId, customerId, checkInDate, checkOutDate);
	     return ResponseEntity.ok(bookings);
	 }
	
  
 
    
}
	 
