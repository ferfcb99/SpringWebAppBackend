package com.apirestaurant.apirestaurant.services;

import java.util.List;

import com.apirestaurant.apirestaurant.exceptions.RestaurantException;
import com.apirestaurant.apirestaurant.jsons.RestaurantRest;

public interface RestaurantService {
	
	public RestaurantRest getRestaurantById(Long id) throws RestaurantException;
	
	public List<RestaurantRest> getRestaurants() throws RestaurantException;
	
}
