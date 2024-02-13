//package com.hotel.bookings.config;
//
//import org.springframework.context.annotation.Bean;
//
//import org.springframework.context.annotation.Configuration;
//import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//import com.hotel.bookings.enums.RoomType;
//
//@Configuration
//	public class JacksonConfig {
//
//	    @Bean
//	    public ObjectMapper objectMapper() {
//	        ObjectMapper objectMapper = new ObjectMapper();
//	        SimpleModule module = new SimpleModule();
//	        module.addSerializer(RoomType.class, new ToStringSerializer());
//	        objectMapper.registerModule(module);
//	        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//	        return objectMapper;
//	    }
//
//}
