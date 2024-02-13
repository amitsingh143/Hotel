package com.hotel.bookings;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Import;

//import com.hotel.bookings.config.JacksonConfi;
//import com.hotel.bookings.config.JacksonConfig;

@SpringBootApplication

//@Import(JacksonConfi.class)

public class BookingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingsApplication.class, args);
	}

}
