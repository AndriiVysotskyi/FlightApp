package com.flightapp.flightapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flightapp.repo.IFlightAppRepository;
import com.flightapp.repo.TicketDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightappApplicationTests {
	private static final int DEFAULT_TICKETID = 125;
	private static final int DEFAULT_DESTINATIONID = 500;
	private static final int DEFAULT_COUPONID = 125;

	@Autowired
	IFlightAppRepository repository;

	@Before
	public void setup() {
		TicketDao ticket = new TicketDao(DEFAULT_TICKETID, true, 100.0);
		repository.addTicket(ticket);
		repository.addCoupon(DEFAULT_COUPONID);
		repository.addDestination(DEFAULT_DESTINATIONID);

	}

	@Test
	public void contextLoads() {
	}

}
