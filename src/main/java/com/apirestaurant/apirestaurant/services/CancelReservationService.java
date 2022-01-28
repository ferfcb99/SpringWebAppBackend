package com.apirestaurant.apirestaurant.services;

import com.apirestaurant.apirestaurant.exceptions.RestaurantException;

public interface CancelReservationService {
	public String deleteReservation(String locator) throws RestaurantException;
}
