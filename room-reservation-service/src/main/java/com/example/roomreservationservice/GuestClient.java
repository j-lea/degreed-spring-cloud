package com.example.roomreservationservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/guests")
@FeignClient("guestservices")
public interface GuestClient {

	@GetMapping("")
	List<Guest> getAllGuests();

	@GetMapping("/{id}")
	Guest getGuest(@PathVariable("id") long id);

}
