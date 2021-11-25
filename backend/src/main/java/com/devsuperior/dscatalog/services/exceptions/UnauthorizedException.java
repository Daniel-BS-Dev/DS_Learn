package com.devsuperior.dscatalog.services.exceptions;


//exceção criada para lançar o erro quando user não tem token
//unauthorized 401 -> token não conhecido

public class UnauthorizedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public UnauthorizedException(String msg) {
		super(msg);
	}

}

