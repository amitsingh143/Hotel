package com.hotel.bookings.controller;


import java.util.Collections;

//import java.time.LocalDateTime;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.bookings.Dto.SearchAvailableRooms;
import com.hotel.bookings.entity.Room;
import com.hotel.bookings.entity.SearchRoomsResponse;
//import com.hotel.bookings.enums.RoomType;
import com.hotel.bookings.exception.RoomUnavailableException;
import com.hotel.bookings.service.RoomService;

import jakarta.validation.Valid;
@Validated
@RestController
@RequestMapping("/rooms")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@PostMapping("/add")
	public ResponseEntity<Room> addRoom(@Valid @RequestBody Room room) {
		Room savedRoom = roomService.addRoom(room);
		return ResponseEntity.ok(savedRoom);
	}

	@PutMapping("/edit/{roomId}")
	public ResponseEntity<Room> editRoom(@Valid @PathVariable int roomId, @RequestBody Room room) {
		Room editedRoom = roomService.editRoom(roomId, room);
		return ResponseEntity.ok(editedRoom);
	}

	@GetMapping("/getAll")
	public List<Room> getAllRoomInfo() {
		List<Room> rooms = roomService.getAllRoomInfo();
		return rooms;
	}



	@PostMapping("/edit")
	public String updateRoom(@Valid @RequestBody Room room) {
		String msg = roomService.updateRoom(room);
		return msg;
	}

	
	
	@PostMapping("/search")
	public ResponseEntity<SearchRoomsResponse> searchRooms(@RequestBody SearchAvailableRooms searchroom) {
	    try {
	        List<Room> availableRooms = roomService.searchRooms(searchroom);
	        return ResponseEntity.ok(new SearchRoomsResponse(availableRooms));
	    } catch (RoomUnavailableException e) {
	        // Return a response with a custom error message
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SearchRoomsResponse("No available rooms found for the specified criteria or Date"));
	    }
	}


	
	
//	@PostMapping("/add")
//	public String addRoom(@RequestBody Room r) {
//		return rms.addRoom(r);
//	}
//	@PutMapping("/edit")
//	public String editRoom(@RequestBody Room r) {
//		return rms.editRoom(r);
//		
//	}
}
