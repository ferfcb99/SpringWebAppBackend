package com.apirestaurant.apirestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apirestaurant.apirestaurant.exceptions.RestaurantException;
import com.apirestaurant.apirestaurant.jsons.CreateReservationRest;
import com.apirestaurant.apirestaurant.responses.RestaurantResponse;
import com.apirestaurant.apirestaurant.services.ReservationService;

@RestController
@RequestMapping(path = "/reservation/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "reservation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestaurantResponse<String> createReservation(@RequestBody CreateReservationRest createReservationRest) throws RestaurantException{
		return new RestaurantResponse<>("Success", String.valueOf(HttpStatus.OK), "OK", reservationService.createReservation(createReservationRest));
	}

}
