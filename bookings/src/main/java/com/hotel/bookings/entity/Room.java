package com.hotel.bookings.entity;

import java.math.BigDecimal;


import java.util.List;

import com.hotel.bookings.enums.RoomType;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

//@Table(name = "room")
@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int roomId;

	


	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	

	public Room(int roomId, @NotEmpty(message = "Hotel name can not be empty") String hotelName,
			@NotNull(message = "roomtype can not be null") RoomType roomType,
			@NotNull(message = "price per day can not be null") BigDecimal pricePerDay, int maxOccupancy,
			List<Bookings> bookings) {
		super();
		this.roomId = roomId;
		this.hotelName = hotelName;
		this.roomType = roomType;
		this.pricePerDay = pricePerDay;
		this.maxOccupancy = maxOccupancy;
		this.bookings = bookings;
	}


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

	public int getMaxOccupancy() {
		return maxOccupancy;
	}

	public void setMaxOccupancy(int maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}

	public List<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(List<Bookings> bookings) {
		this.bookings = bookings;
	}

	@Column
	@NotEmpty(message="Hotel name can not be empty")
	private String hotelName;

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", hotelName=" + hotelName + ", roomType=" + roomType + ", pricePerDay="
				+ pricePerDay + ", maxOccupancy=" + maxOccupancy + ", bookings=" + bookings + "]";
	}

	@NotNull(message="roomtype can not be null")
	@Enumerated(EnumType.STRING)
	// @Column(name = "roomtype", columnDefinition = "roomtype")
	private RoomType roomType;

	@Column
	@NotNull(message ="price per day can not be null")
	private BigDecimal pricePerDay;

	@Column
	private int maxOccupancy;

	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private List<Bookings> bookings;

}
