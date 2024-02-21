package com.hotel.bookings.entity;

import java.util.List;


public class SearchRoomsResponse {
	
    private List<Room> rooms;
    private String errorMessage;

    // Constructor for successful response
    public SearchRoomsResponse(List<Room> rooms) {
        this.rooms = rooms;
    }

    // Constructor for error response
    public SearchRoomsResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    // Getters and setters
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public SearchRoomsResponse(List<Room> rooms, String errorMessage) {
		super();
		this.rooms = rooms;
		this.errorMessage = errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
