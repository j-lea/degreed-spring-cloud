package com.example.roomreservationservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room-reservations")
public class RoomReservationWebService {

	private final RoomClient roomClient;
	private final ReservationClient reservationClient;
	private final GuestClient guestClient;

	public RoomReservationWebService(RoomClient roomClient, ReservationClient reservationClient, GuestClient guestClient) {
		this.roomClient = roomClient;
		this.reservationClient = reservationClient;
		this.guestClient = guestClient;
	}

	@GetMapping
	public List<RoomReservation> getRoomReservations() {
		List<RoomReservation> roomReservations = new ArrayList<>();

		List<Reservation> reservations = this.reservationClient.getAllReservations();

		reservations.forEach(reservation -> {
			RoomReservation roomReservation = new RoomReservation();
			roomReservation.setDate(reservation.getResDate());
			roomReservation.setRoomId(reservation.getRoomId());
			roomReservation.setGuestId(reservation.getGuestId());

			Room room = this.roomClient.getRoom(reservation.getRoomId());
			roomReservation.setRoomNumber(room.getRoomNumber());
			roomReservation.setRoomName(room.getName());

			Guest guest = this.guestClient.getGuest(reservation.getGuestId());
			roomReservation.setFirstName(guest.getFirstName());
			roomReservation.setLastName(guest.getLastName());

			roomReservations.add(roomReservation);
		});

		return roomReservations;
	}
}
