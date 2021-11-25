package com.devsuperior.dscatalog.resources.exceptions;

import java.io.Serializable;

//esta classe foi criada para mostrar o erro customizado quando o user não tem o token, no pacote de services eu vou criar outra exceção
// para lançar como erro

import com.fasterxml.jackson.annotation.JsonProperty;

//essa classe foi criada para retornar um erro caso o usuario não tenha token ou seu acesso não seja permitido, classe resourceExceptionHandler

public class OAuthCustomError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private String error;
	
	@JsonProperty("error_description")// essa anotação é para dizer que ter esse ifen no meio separando os dois nomes
	private String description;
	
	
	public OAuthCustomError() {
		
	}

	public OAuthCustomError(String error, String description) {
		super();
		this.error = error;
		this.description = description;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}

