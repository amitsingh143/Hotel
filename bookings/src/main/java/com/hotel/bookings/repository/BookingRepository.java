package com.hotel.bookings.repository;

//import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.hotel.bookings.entity.Bookings;


@Repository
public interface BookingRepository extends JpaRepository<Bookings, Integer> {
	
   // List<Bookings> findByRoomAndCustomerAndCheckInDateBetweenOrRoomAndCustomerAndCheckOutDateBetween(Room room, Customer customer, LocalDateTime checkInDate, LocalDateTime checkOutDate);
   // List<Integer> findByBookingId(LocalDateTime checkInDate, LocalDateTime checkOutDate);
    
	//List<Integer> findBookedRoomIds(LocalDateTime checkInDate, LocalDateTime checkOutDate);
	

//	@Query(value = "SELECT * FROM bookings b WHERE b.roomid = :roomId AND " +
//	           "((b.checkindate >= :checkInDate AND b.checkindate <= :checkOutDate) OR " +
//	           "(b.checkoutdate >= :checkInDate AND b.checkoutdate <= :checkOutDate))", nativeQuery = true)
	
	@Query(value = "SELECT * FROM bookings b WHERE b.roomid = :roomId AND " +
            "((b.check_in_date >= :checkInDate AND b.check_in_date <= :checkOutDate) OR " +
            "(b.check_out_date >= :checkInDate AND b.check_out_date <= :checkOutDate))", nativeQuery = true)

	    List<Bookings> findConflictingBookings(@Param("roomId") Integer roomId,
	                                          @Param("checkInDate") Date checkInDate,
	                                          @Param("checkOutDate") Date checkOutDate);

//	List<Bookings> findByCheckInDateAndCheckOutDate(Integer roomId, Integer customerId, LocalDateTime checkInDate,
//			LocalDateTime checkOutDate);

	List<Bookings> findByCheckInDateAndCheckOutDate(Date checkInDate, Date checkOutDate);
	    
	

}

