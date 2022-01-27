package com.apirestaurant.apirestaurant.services;

import com.apirestaurant.apirestaurant.exceptions.RestaurantException;
import com.apirestaurant.apirestaurant.jsons.CreateReservationRest;
import com.apirestaurant.apirestaurant.jsons.ReservationRest;

public interface ReservationService {
	
	public ReservationRest getReservation(Long id) throws RestaurantException;
	
	public String createReservation(CreateReservationRest createReservationRest) throws RestaurantException;

}
