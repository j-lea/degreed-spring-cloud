package com.example.roomreservationservice;

import java.util.List;

import org.hibernate.validator.constraints.pl.REGON;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/rooms")
@FeignClient("roomservices")
public interface RoomClient {

	@GetMapping()
	List<Room> getAllRooms();

	@GetMapping("/{id}")
	Room getRoom(@PathVariable("id") long id);

}
