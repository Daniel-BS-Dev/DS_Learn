package com.devsuperior.dscatalog.services.exceptions;

public class Forbidden extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public Forbidden(String msg) {
		super(msg);
	}

}

