package com.flightapp.flightapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.model.IFlightApp;

@ComponentScan({ "com.flightapp.model", "com.flightapp.repo" })
@RestController
public class FlightAppRestController {
	@Autowired
	IFlightApp flightApp;

	@GetMapping(FlightAppConstants.TICKETS + FlightAppConstants.AVAILABILITY)
	public Boolean checkTicketsAvailability(@RequestParam("ticketId") Integer ticketId) {
		return flightApp.checkTicketsAvailability(ticketId);
	}

	@PostMapping(FlightAppConstants.BAGGAGE)
	public Boolean baggageCheckIn(@RequestParam("destinationId") Integer destinationId,
			@RequestParam("baggageId") String baggageId) {
		return flightApp.baggageCheckIn(destinationId, baggageId);
	}

	@PutMapping(FlightAppConstants.COUPON)
	public Boolean validateCoupon(@RequestParam("couponId") Integer couponId, @RequestParam("price") Double price) {
		return flightApp.validateCoupon(couponId, price);
	}
}
