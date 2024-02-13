package com.hotel.bookings.repository;

import java.math.BigDecimal;

//import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hotel.bookings.entity.Room;

import com.hotel.bookings.enums.RoomType;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

	// List<Room> findByRoomTypeAndMaxOccupancyGreaterThanEqual(RoomType roomType,
	// int occupancy);

//	List<Room> findByRoomTypeAndRoomIdNotInAndMaxOccupancyGreaterThanEqual(RoomType roomType, List<Integer> bookedRoomIds,
//			int maxOccupancy);
//	
	@Query("SELECT r FROM Room r WHERE r.roomType = :roomType " +
		       "AND r.pricePerDay <= :pricePerDay " +
		       "AND r.roomId NOT IN (" +
		       "   SELECT b.room.roomId FROM Bookings b " +
		       "   WHERE (b.checkInDate <= :checkOutDate AND b.checkOutDate >= :checkInDate)" +
		       ")")

	
	
	List<Room> searchAvailableRooms(@Param("roomType") RoomType roomType, @Param("checkInDate") Date checkInDate,
			@Param("checkOutDate") Date checkOutDate, @Param("pricePerDay") BigDecimal pricePerDay);

}
