package com.hotel.bookings.Dto;

//import java.time.LocalDateTime;
import java.util.Date;

//import com.fasterxml.jackson.annotation.JsonFormat;
import com.hotel.bookings.entity.Customer;
import com.hotel.bookings.entity.Room;
import com.hotel.bookings.enums.BookingStatus;

public class BookingRequest {

	private Customer customer;

	public BookingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BookingRequest [customer=" + customer + ", checkInDate=" + checkInDate + ", checkOutDate="
				+ checkOutDate + ", bookingId=" + bookingId + ", room=" + room + ", status=" + status + "]";
	}

	public BookingRequest(Customer customer, Date checkInDate, Date checkOutDate, int bookingId, Room room,
			BookingStatus status) {
		super();
		this.customer = customer;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.bookingId = bookingId;
		this.room = room;
		this.status = status;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	private Date checkInDate;

	private Date checkOutDate;
	private int bookingId;
	private Room room;
	private BookingStatus status;

}
