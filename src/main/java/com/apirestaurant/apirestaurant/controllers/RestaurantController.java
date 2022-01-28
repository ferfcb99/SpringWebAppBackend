package com.apirestaurant.apirestaurant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apirestaurant.apirestaurant.exceptions.RestaurantException;
import com.apirestaurant.apirestaurant.jsons.RestaurantRest;
import com.apirestaurant.apirestaurant.responses.RestaurantResponse;
import com.apirestaurant.apirestaurant.services.RestaurantService;

@RestController
@RequestMapping(path = "/restaurant/v1")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;
	
	// end points

	// /restaurant/v1/restaurant/{restaurantId}
	
	// http://localhost:8084/restaurant/v1
	
	
	// http://localhost:8084/restaurant/v1//restaurant/1
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/restaurant/{restaurantId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestaurantResponse<RestaurantRest> getRestaurantById(@PathVariable Long restaurantId)
			throws RestaurantException {
		return new RestaurantResponse<RestaurantRest>("Success", String.valueOf(HttpStatus.OK), "OK",
				restaurantService.getRestaurantById(restaurantId));
	}
	
	
	// http://localhost:8084/restaurant/v1/restaurants
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestaurantResponse<List<RestaurantRest>> getRestaurants() throws RestaurantException{
		return new RestaurantResponse<> ("Success", String.valueOf(HttpStatus.OK), "OK",
				restaurantService.getRestaurants());
	}

}
