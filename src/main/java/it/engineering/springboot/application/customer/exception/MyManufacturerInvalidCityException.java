package it.engineering.springboot.application.customer.exception;

public class MyManufacturerInvalidCityException extends MyApplicationException {
	
	private static final long serialVersionUID = 1L;

	public MyManufacturerInvalidCityException(String message) {
		super(message);

	}

}
