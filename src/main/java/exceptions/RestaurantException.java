package exceptions;

import java.util.List;

import dtos.ErrorDto;

import java.util.ArrayList;

public class RestaurantException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private final String code; // OK
	
	private final int responseCode; // 200
	
	private final List<ErrorDto> errorList = new ArrayList<>();
	
	public RestaurantException(String code, int responseCode, String message) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
	}
	
	public RestaurantException(String code, int responseCode, String message, List<ErrorDto> errorList) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
		this.errorList.addAll(errorList);
	}

	public String getCode() {
		return code;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public List<ErrorDto> getErrorList() {
		return this.errorList;
	}
	
	
	
}
