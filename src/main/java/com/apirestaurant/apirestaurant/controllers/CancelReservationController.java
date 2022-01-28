package com.apirestaurant.apirestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apirestaurant.apirestaurant.exceptions.RestaurantException;
import com.apirestaurant.apirestaurant.responses.RestaurantResponse;
import com.apirestaurant.apirestaurant.services.CancelReservationService;

@RestController
@RequestMapping(path = "/cancel-reservation/v1")
public class CancelReservationController {
	
	@Autowired
	CancelReservationService cancelReservationService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/cancel", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestaurantResponse<String> deleteReservation(@RequestParam String locator) throws RestaurantException{
		return new RestaurantResponse<>("Success", String.valueOf(HttpStatus.OK), "OK", cancelReservationService.deleteReservation(locator));
	}
}
