package com.apirestaurant.apirestaurant.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.apirestaurant.apirestaurant.dtos.ErrorDto;

public class InternalServerErrorException extends RestaurantException{
	
	private static final long serialVersionUID = 1L;
	
	public InternalServerErrorException(String code, String message) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}
	
	
	public InternalServerErrorException(String code, String message, ErrorDto errorList) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(errorList));
	}
	
}
