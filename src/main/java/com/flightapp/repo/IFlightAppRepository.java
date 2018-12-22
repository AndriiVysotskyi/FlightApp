package com.flightapp.repo;

public interface IFlightAppRepository {
	TicketDao getTicket(Integer ticketId);

	Boolean addBaggage(Integer destinationId, String baggageId);

	Integer getCoupon(Integer couponId);

	void removeCoupon(Integer couponId);

	int[] getDiscounts();

}
