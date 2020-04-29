package com.example.guestservices;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
public class GuestWebServices {

	private final GuestRepository repository;

	public GuestWebServices(GuestRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public Iterable<Guest> getAllGuests() {
		return this.repository.findAll();
	}

	@GetMapping("/{id}")
	public Guest getGuest(@PathVariable("id") long id) {
		Optional<Guest> potentialGuest = this.repository.findById(id);
		return potentialGuest.orElse(null);
	}
}
