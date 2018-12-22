package com.flightapp.repo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class FlightAppRepository implements IFlightAppRepository {
	Map<Integer, TicketDao> tickets = new HashMap<>();
	Map<Integer, Set<String>> baggages = new HashMap<>();
	Set<Integer> coupons = new HashSet<>();
	int[] discounts = new int[] { 10, 50, 60 };

	@Override
	public Boolean addBaggage(Integer destinationId, String baggageId) {
		Set<String> destinationBaggages = null;
		if (baggages.containsKey(destinationId)) {
			destinationBaggages = baggages.get(destinationId);
		} else {
			return false;
		}
		if (destinationBaggages.contains(baggageId)) {
			return false;
		} else {
			destinationBaggages.add(baggageId);
			baggages.put(destinationId, destinationBaggages);
		}
		return true;
	}

	@Override
	public Integer getCoupon(Integer couponId) {
		if (coupons.contains(couponId)) {
			return couponId;
		}
		return null;
	}

	@Override
	public void removeCoupon(Integer couponId) {
		if (coupons.contains(couponId)) {
			coupons.remove(couponId);
		}

	}

	@Override
	public TicketDao getTicket(Integer ticketId) {
		if (tickets.containsKey(ticketId)) {
			return tickets.get(ticketId);
		}
		return null;
	}

	@Override
	public int[] getDiscounts() {
		return discounts;
	}

}
