package com.flightapp.model;

public interface IFlightApp {
	Boolean checkTicketsAvailability(Integer ticketId);

	Boolean baggageCheckIn(Integer destinationId, String baggageId);

	Boolean validateCoupon(Integer couponId, Double price);

}
