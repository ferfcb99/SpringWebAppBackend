package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exceptions.RestaurantException;
import jsons.RestaurantRest;
import responses.RestaurantResponse;
import services.RestaurantService;

@RestController
@RequestMapping(path = "/restaurant/v1")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	public RestaurantResponse<RestaurantRest> getRestaurantById(@PathVariable Long restaurantId)
			throws RestaurantException {
		return new RestaurantResponse<RestaurantRest>("Success", String.valueOf(HttpStatus.OK), "OK",
				restaurantService.getRestaurantById(restaurantId));
	}
	
	public RestaurantResponse<List<RestaurantRest>> getRestaurants() throws RestaurantException{
		return new RestaurantResponse<> ("Success", String.valueOf(HttpStatus.OK), "OK",
				restaurantService.getRestaurants());
	}

}
