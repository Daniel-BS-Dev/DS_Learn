package com.devsuperior.dscatalog.services.exceptions;

//exceção criada para lançar o erro quando user tem o token mas não é permitido o acesso a tal ação
//forbidden 403 -> acesso negado

public class ForbiddenException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ForbiddenException(String msg) {
		super(msg);
	}

}

