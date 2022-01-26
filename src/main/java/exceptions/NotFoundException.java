package exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import dtos.ErrorDto;

public class NotFoundException extends RestaurantException{


	private static final long serialVersionUID = 1L;
	
	public NotFoundException(String code, String message) {
		super(code, HttpStatus.NOT_FOUND.value(), message);
	}
	
	
	public NotFoundException(String code, String message, ErrorDto errorList) {
		super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(errorList));
	}

	
}
