package com.apirestaurant.apirestaurant.services.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestaurant.apirestaurant.entities.Reservation;
import com.apirestaurant.apirestaurant.entities.Restaurant;
import com.apirestaurant.apirestaurant.entities.Turn;
import com.apirestaurant.apirestaurant.exceptions.InternalServerErrorException;
import com.apirestaurant.apirestaurant.exceptions.RestaurantException;
import com.apirestaurant.apirestaurant.jsons.CreateReservationRest;
import com.apirestaurant.apirestaurant.jsons.ReservationRest;
import com.apirestaurant.apirestaurant.repositories.ReservationRepository;
import com.apirestaurant.apirestaurant.repositories.RestaurantRepository;
import com.apirestaurant.apirestaurant.repositories.TurnRepository;
import com.apirestaurant.apirestaurant.services.ReservationService;

import javassist.NotFoundException;


@Service
public class ReservationtServiceImpl implements ReservationService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationtServiceImpl.class);
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	TurnRepository turnRepository;
	
	
	public static final ModelMapper modelMapper = new ModelMapper();
	

	public ReservationRest getReservation(Long id) throws RestaurantException {
		try {
			return modelMapper.map(getResevationEntity(id), ReservationRest.class);
		} catch (RestaurantException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
		return null;
	}
	
	public Reservation getResevationEntity(Long idReservation) throws RestaurantException, NotFoundException{
		
		return reservationRepository.findById(idReservation).orElseThrow(() -> new NotFoundException("SNOT-404-1"));
		
	}

	public String createReservation(CreateReservationRest createReservationRest) throws RestaurantException {
		// reparar el orElse
		final Restaurant restaurantId = restaurantRepository.findById(createReservationRest.getRestaurantId()).orElse(null);
		
		final Turn turnId = turnRepository.findById(createReservationRest.getTurnId()).orElse(null);
		
		// idRestaurant + Create reservation
		
		String locator = generateLocator(restaurantId, createReservationRest);
		
		final Reservation reservation = new Reservation();
		
		reservation.setLocator(locator);
		reservation.setPerson(createReservationRest.getPerson());
		reservation.setDate(createReservationRest.getDate());
		reservation.setRestaurant(restaurantId);
		reservation.setTurn(turnId.getName());
		
		try{
			reservationRepository.save(reservation);
		}catch(final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		
		return locator;
	}
	
	
	private String generateLocator(Restaurant restaurantId, CreateReservationRest createResevationRest) throws RestaurantException{
		return restaurantId.getName() + createResevationRest.getTurnId();
	}

}




















