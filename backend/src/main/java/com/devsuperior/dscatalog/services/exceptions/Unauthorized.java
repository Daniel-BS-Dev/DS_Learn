package com.devsuperior.dscatalog.services.exceptions;

public class Unauthorized extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public Unauthorized(String msg) {
		super(msg);
	}

}

