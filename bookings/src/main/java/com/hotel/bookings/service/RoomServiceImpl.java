package com.hotel.bookings.service;

import java.math.BigDecimal;


//import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.bookings.Dto.SearchAvailableRooms;
import com.hotel.bookings.entity.Bookings;
import com.hotel.bookings.entity.Room;
import com.hotel.bookings.enums.RoomType;

import com.hotel.bookings.exception.RoomNotFoundException;
import com.hotel.bookings.exception.RoomUnavailableException;
import com.hotel.bookings.repository.BookingRepository;
import com.hotel.bookings.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public Room addRoom(Room room) {
		// Add any validation or business logic here
		System.out.println("room data is saved");
		return roomRepository.save(room);
	}

	@Override
	public Room editRoom(int roomId, Room room) {
		// Add validation and update logic here
		Room existingRoom = roomRepository.findById(roomId)
				.orElseThrow(() -> new RoomNotFoundException("Room not found"));
		// Update existingRoom with roomDetails
		existingRoom.setHotelName(room.getHotelName());
		existingRoom.setRoomType(room.getRoomType());
		// Update other fields as needed
		return roomRepository.save(existingRoom);
	}

	@Override
	public List<Room> getAllRoomInfo() {
		List<Room> roomList = roomRepository.findAll();
		return roomList;
	}

//
	@Override
	public String updateRoom(Room room) {
		roomRepository.save(room);
		return "room data  is updated";
	}

//	@Override
//	public String addRoom(Room r) {
//		rmr.save(r);
//		return "Room is added";
//	}

//	@Override
//	public String editRoom(Room r) {
//		rmr.save(r);
//		return "Room details are updated";
//	}

	@Override
	public List<Room> searchRooms(SearchAvailableRooms searchroom) {
		Date checkInDate = searchroom.getCheckInDate();
		Date checkOutDate = searchroom.getCheckOutDate();
		RoomType roomType = searchroom.getRoomType();
		BigDecimal pricePerDay = searchroom.getPricePerDay();

		List<Room> availableRooms = roomRepository.searchAvailableRooms(roomType, checkInDate, checkOutDate,
				pricePerDay);

		if (availableRooms.isEmpty()) {
			throw new RoomUnavailableException("No available rooms of type " + roomType + " for the specified dates: "
					+ checkInDate + " to " + checkOutDate);
		}

		return availableRooms;
	}

	@Override
	public void validateRoomExists(Room room) {
		if (room == null || !roomRepository.existsById(room.getRoomId())) {
			throw new RoomNotFoundException("Room not found");
		}
	}

	@Override
	public void validateRoomAvailability(Room room, Date checkInDate, Date checkOutDate) {
		List<Bookings> conflictingBookings = bookingRepository.findConflictingBookings(room.getRoomId(), checkInDate,
				checkOutDate);

		if (!conflictingBookings.isEmpty()) {
			throw new RoomUnavailableException("Room is not available for the specified dates.");
		}
	}

	@Override
	public Room getRoomById(int roomId) {
		return roomRepository.findById(roomId)
				.orElseThrow(() -> new RoomNotFoundException("Room not found with id: " + roomId));
	}

	@Override
	public Room getRoom(Room room) {
		// Assuming the provided room object has the ID of the room you want to retrieve
		int roomId = room.getRoomId();

		// Retrieve the room from the repository using its ID
		return roomRepository.findById(roomId)
				.orElseThrow(() -> new RoomNotFoundException("Room not found with ID: " + roomId));
	}

	

}
