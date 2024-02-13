package com.hotel.bookings.entity;

import java.math.BigDecimal;

//import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;

//import com.hotel.bookings.enums.BookingStatus;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

//@Table(name = "bookings")

@Entity
public class Bookings {

	public Bookings() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int bookingId;

	@ManyToOne
	@JoinColumn(name = "roomid")
	private Room room;

	@ManyToOne
	@JoinColumn(name = "customerid")
	private Customer customer;
	@Column(name = "check_in_date")
	private Date checkInDate;

	@Column(name = "check_out_date")
	private Date checkOutDate;

	private BigDecimal totalPrice;

	@NotNull
	// @Enumerated(EnumType.STRING)
	// @Column(name = "status", columnDefinition = "status")
	private String status;

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Bookings(int bookingId, Room room, Customer customer, Date checkInDate, Date checkOutDate,
			BigDecimal totalPrice, @NotNull String status) {
		super();
		this.bookingId = bookingId;
		this.room = room;
		this.customer = customer;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.totalPrice = totalPrice;
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

	@Override
	public String toString() {
		return "Bookings [bookingId=" + bookingId + ", room=" + room + ", customer=" + customer + ", checkInDate="
				+ checkInDate + ", checkOutDate=" + checkOutDate + ", totalPrice=" + totalPrice + ", status=" + status
				+ "]";
	}

}
