package com.hotel.bookings.service;


//import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.hotel.bookings.Dto.SearchAvailableRooms;
import com.hotel.bookings.entity.Room;
//import com.hotel.bookings.enums.RoomType;

public interface RoomService {
	// List<Room> findAvailableRooms(RoomType roomType, LocalDateTime checkInDate,
	// LocalDateTime checkOutDate,Integer maxOccupancy);

	// String addRoom(Room room);

	String updateRoom(Room room);

	List<Room> getAllRoomInfo();

	Room editRoom(int roomId, Room room);

	Room addRoom(Room room);

	void validateRoomExists(Room room);

	void validateRoomAvailability(Room room, Date checkInDate, Date checkOutDate);

	Room getRoom(Room room);

	List<Room> searchRooms(SearchAvailableRooms searchroom);

	Room getRoomById(int roomId);

	// Room editRoom(int roomId, Room room);

}
