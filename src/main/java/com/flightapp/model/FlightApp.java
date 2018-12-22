package com.flightapp.model;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.repo.IFlightAppRepository;
import com.flightapp.repo.TicketDao;

@Service
public class FlightApp implements IFlightApp {
	@Autowired
	IFlightAppRepository repository;

	@Override
	public Boolean checkTicketsAvailability(Integer ticketId) {
		TicketDao ticket = repository.getTicket(ticketId);
		if (ticket != null) {
			return ticket.getAvailability();
		}
		return false;
	}

	@Override
	public Boolean baggageCheckIn(Integer destinationId, String baggageId) {

		return repository.addBaggage(destinationId, baggageId);
	}

	@Override
	public Boolean validateCoupon(Integer couponId, Double price) {
		Integer coupon = repository.getCoupon(couponId);
		if (coupon != null) {
			calculateDiscountedPrice(price);
			repository.removeCoupon(couponId);
		}

		return false;
	}

	private void calculateDiscountedPrice(Double price) {
		Random rand = new Random();
		int pointer = rand.nextInt(3 - 1 + 1) + 1;
		int[] disounts = repository.getDiscounts();
		int discount = disounts[pointer];
		double discountedPrice = price - (price / 100) * discount;
	}

}
