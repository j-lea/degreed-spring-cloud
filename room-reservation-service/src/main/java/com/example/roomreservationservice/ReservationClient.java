package com.example.roomreservationservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reservations")
@FeignClient("reservationservices")
public interface ReservationClient {

	@GetMapping()
	List<Reservation> getAllReservations();

	@GetMapping("/{id}")
	Reservation getReservation(@PathVariable("id") long id);

}
