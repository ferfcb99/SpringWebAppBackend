package com.apirestaurant.apirestaurant.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestaurant.apirestaurant.entities.Restaurant;
import com.apirestaurant.apirestaurant.exceptions.RestaurantException;
import com.apirestaurant.apirestaurant.jsons.RestaurantRest;
import com.apirestaurant.apirestaurant.repositories.RestaurantRepository;
import com.apirestaurant.apirestaurant.services.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;

	// model mapper sirve para serializar y deserializar
	public static final ModelMapper modelMapper = new ModelMapper();

	
	public RestaurantRest getRestaurantById(Long id) throws RestaurantException {
		return modelMapper.map(getRestaurantEntity(id), RestaurantRest.class);
	}

	// metodo o funcion que retorna un objeto tipo restaurante
	private Restaurant getRestaurantEntity(Long idRestaurant) throws RestaurantException {
		return restaurantRepository.findById(idRestaurant)
				.orElseThrow(null);
		// new NotFoundException("SNOT-404-1", "RESTAURANT_NOT_FOUND")
	}

	
	public List<RestaurantRest> getRestaurants() throws RestaurantException {
		final List<Restaurant> restaurants = restaurantRepository.findAll();
		return restaurants.stream().map(service -> 
			modelMapper.map(service, RestaurantRest.class))
				.collect(Collectors.toList());
	}

}
