package it.engineering.springboot.application.customer.exception;

import it.engineering.springboot.application.customer.dto.MyDto;

public class MyEntityNotExistException extends MyApplicationException {

	private static final long serialVersionUID = 1L;

	private final MyDto entity;

	public MyEntityNotExistException(String message, MyDto entity) {
		super(message);
		this.entity = entity;
	}

	public MyDto getEntity() {
		return entity;
	}

}
