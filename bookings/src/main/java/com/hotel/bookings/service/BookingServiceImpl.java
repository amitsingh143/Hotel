package com.hotel.bookings.service;

import java.math.BigDecimal;
import java.util.ArrayList;
//import java.time.LocalDateTime;
//import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.bookings.Dto.BookingRequest;
import com.hotel.bookings.entity.Bookings;
import com.hotel.bookings.entity.Customer;
import com.hotel.bookings.entity.Room;
//import com.hotel.bookings.enums.BookingStatus;
//import com.hotel.bookings.exception.CustomerNotFoundException;
import com.hotel.bookings.exception.InvalidBookingException;
//import com.hotel.bookings.exception.RoomNotFoundException;
import com.hotel.bookings.exception.RoomUnavailableException;
import com.hotel.bookings.repository.BookingRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private RoomService roomService;

	@Autowired
	private CustomerService customerService;
	
	 @PersistenceContext
	    private EntityManager entityManager;
	 
	 
	    public List<Bookings> searchBookings(Integer roomId, Integer customerId, Date checkInDate, Date checkOutDate) {
	        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Bookings> cq = cb.createQuery(Bookings.class);
	        Root<Bookings> root = cq.from(Bookings.class);
	        
	        List<Predicate> predicates = new ArrayList<>();
	        
	        // Add conditions based on parameters
	        if (roomId != null) {
	            predicates.add(cb.equal(root.get("room").get("roomId"), roomId));
	        }
	        if (customerId != null) {
	            predicates.add(cb.equal(root.get("customer").get("customerId"), customerId));
	        }
	        if (checkInDate != null && checkOutDate != null) {
	            predicates.add(cb.between(root.get("checkInDate"), checkInDate, checkOutDate));
	            predicates.add(cb.between(root.get("checkOutDate"), checkInDate, checkOutDate));
	        }
	        
	        cq.where(predicates.toArray(new Predicate[0]));
	        
	        TypedQuery<Bookings> query = entityManager.createQuery(cq);
	        return query.getResultList();
	    }

	@Override
	public Bookings bookRoom(BookingRequest bookingRequest) throws RoomUnavailableException {
		validateBookingRequest(bookingRequest);

		Room room = bookingRequest.getRoom();
		Customer customer = bookingRequest.getCustomer();

		roomService.validateRoomExists(room);
		customerService.validateCustomerExists(customer);

		roomService.validateRoomAvailability(room, bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate());

		// Calculate the total price
		BigDecimal totalPrice = calculateTotalPrice(room.getPricePerDay(), bookingRequest.getCheckInDate(),
				bookingRequest.getCheckOutDate());

		// Create and save the booking
		Bookings booking = new Bookings();
		booking.setRoom(roomService.getRoom(room));
		booking.setCustomer(customerService.getCustomer(customer));
		booking.setCheckInDate(bookingRequest.getCheckInDate());
		booking.setCheckOutDate(bookingRequest.getCheckOutDate());
		booking.setStatus(bookingRequest.getStatus()); // Assuming the initial status is "Reserved"
		booking.setTotalPrice(totalPrice); // Set the total price for the booking

		return bookingRepository.save(booking);
	}

//	private BigDecimal calculateTotalPrice(BigDecimal pricePerDay, Date checkInDate,
//			Date checkOutDate) {
//		long days = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
//		return pricePerDay.multiply(BigDecimal.valueOf(days));
//	}

	private BigDecimal calculateTotalPrice(BigDecimal pricePerDay, Date checkInDate, Date checkOutDate) {
		long diffInMillies = Math.abs(checkOutDate.getTime() - checkInDate.getTime());
		long days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		return pricePerDay.multiply(BigDecimal.valueOf(days));
	}
//
//	private BigDecimal calculateTotalPrice(BookingRequest bookingRequest) {
//		 return BigDecimal.valueOf(100.0);
//	}

	private void validateBookingRequest(BookingRequest bookingRequest) {
		if (bookingRequest.getRoom() == null || bookingRequest.getCustomer() == null
				|| bookingRequest.getCheckInDate() == null || bookingRequest.getCheckOutDate() == null) {
			throw new InvalidBookingException("Booking request is missing required fields.");
		}

	}

//////search bookings
//	@Override
//	public List<Bookings> searchBookings(Integer roomId, Integer customerId, Date checkInDate, Date checkOutDate) {
//		if (roomId == null && customerId == null && checkInDate == null && checkOutDate == null) {
//			// If no search criteria provided, return all bookings
//			return bookingRepository.findAll();
//		} else {
//			// If search criteria provided, use them to filter bookings
//			return bookingRepository.findByCheckInDateAndCheckOutDate(checkInDate, checkOutDate);
//		}
//	}

}
