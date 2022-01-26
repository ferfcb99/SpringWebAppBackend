package services;

import java.util.List;

import exceptions.RestaurantException;
import jsons.RestaurantRest;

public interface RestaurantService {
	
	public RestaurantRest getRestaurantById(Long id) throws RestaurantException;
	
	public List<RestaurantRest> getRestaurants() throws RestaurantException;
	
}
