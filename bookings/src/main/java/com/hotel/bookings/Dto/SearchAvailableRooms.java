package com.hotel.bookings.Dto;

import java.math.BigDecimal;

//import java.time.LocalDateTime;
import java.util.Date;

import com.hotel.bookings.enums.RoomType;

public class SearchAvailableRooms {

	private RoomType roomType;
	private Date checkInDate;
	private Date checkOutDate;
	private BigDecimal pricePerDay;

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public BigDecimal getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(BigDecimal pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public SearchAvailableRooms(RoomType roomType, Date checkInDate, Date checkOutDate, BigDecimal pricePerDay) {
		super();
		this.roomType = roomType;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.pricePerDay = pricePerDay;
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

	public SearchAvailableRooms() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SearchAvailableRooms [roomType=" + roomType + ", checkInDate=" + checkInDate + ", checkOutDate="
				+ checkOutDate + ", pricePerDay=" + pricePerDay + "]";
	}

}
