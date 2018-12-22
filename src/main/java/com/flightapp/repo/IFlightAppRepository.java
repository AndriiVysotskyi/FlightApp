package com.flightapp.repo;

public interface IFlightAppRepository {
	TicketDao getTicket(Integer ticketId);

	Boolean addBaggage(Integer destinationId, String baggageId);

	Integer getCoupon(Integer couponId);

	void removeCoupon(Integer couponId);

	int[] getDiscounts();

	void addTicket(TicketDao ticket);

	void addDestination(Integer destinationId);

	void addCoupon(Integer couponId);

}
