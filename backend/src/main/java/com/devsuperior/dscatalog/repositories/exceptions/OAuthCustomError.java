package com.devsuperior.dscatalog.repositories.exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

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

