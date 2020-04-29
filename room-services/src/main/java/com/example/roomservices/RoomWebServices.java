package com.example.roomservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomWebServices {

	private RoomRepository repository;

	public RoomWebServices(RoomRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public Iterable<Room> getAllRooms() {

		Iterable<Room> all = repository.findAll();
		return all;
	}

	@GetMapping("/{id}")
	public Room getRoom(@PathVariable("id") long id) {
		return repository.findById(id).orElse(null);
	}
}
