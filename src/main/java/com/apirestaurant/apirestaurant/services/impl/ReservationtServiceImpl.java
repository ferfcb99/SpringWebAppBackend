package com.apirestaurant.apirestaurant.services.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.apirestaurant.apirestaurant.entities.Reservation;
import com.apirestaurant.apirestaurant.exceptions.RestaurantException;
import com.apirestaurant.apirestaurant.jsons.CreateReservationRest;
import com.apirestaurant.apirestaurant.jsons.ReservationRest;
import com.apirestaurant.apirestaurant.repositories.ReservationRepository;
import com.apirestaurant.apirestaurant.repositories.RestaurantRepository;
import com.apirestaurant.apirestaurant.repositories.TurnRepository;
import com.apirestaurant.apirestaurant.services.ReservationService;

import javassist.NotFoundException;

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
		// TODO Auto-generated method stub
		return null;
	}

}
