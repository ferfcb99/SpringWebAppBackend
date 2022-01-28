package com.apirestaurant.apirestaurant.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestaurant.apirestaurant.exceptions.InternalServerErrorException;
import com.apirestaurant.apirestaurant.exceptions.RestaurantException;
import com.apirestaurant.apirestaurant.repositories.ReservationRepository;
import com.apirestaurant.apirestaurant.services.CancelReservationService;

@Service
public class CancelReservationServiceImpl implements CancelReservationService{

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationtServiceImpl.class);
	
	@Autowired
	private ReservationRepository reservationRepository;

	public String deleteReservation(String locator) throws RestaurantException {
		reservationRepository.findByLocator(locator).orElse(null);
		
		try {
			reservationRepository.deleteByLocator(locator);
		}catch(Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		
		return "locator deleted";
	}
	
	
	
	
}
