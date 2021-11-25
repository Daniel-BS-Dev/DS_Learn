package com.devsuperior.dscatalog.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.dscatalog.services.exceptions.DatabaseException;
import com.devsuperior.dscatalog.services.exceptions.ForbiddenException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;
import com.devsuperior.dscatalog.services.exceptions.UnauthorizedException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	// não tem id
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> EntityNotFound(ResourceNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("resource not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	// apagar uma entidade com relacionamento
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Database execption");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	// validation exception
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidationError err = new ValidationError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Data invalid");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		for(FieldError f: e.getBindingResult().getFieldErrors()) {
		    err.addError(f.getField(), f.getDefaultMessage());
		}
		
		return ResponseEntity.status(status).body(err);
	}

	//tem token mas o acesso não é permitido para o perfil, se o usuario acessa o id 2 tem que lançar essa exceção
	// o retorno do erro vem da classe OAuthCustomError, o tipo da exceção vem do meu pacote de serviceException
	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<OAuthCustomError> forbidden(ForbiddenException e, HttpServletRequest request){
		OAuthCustomError err = new  OAuthCustomError("Forbidden", e.getMessage());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	}
	
	// não tem token
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<OAuthCustomError> unauthozed(UnauthorizedException e, HttpServletRequest request){
		OAuthCustomError err = new  OAuthCustomError("Anauthrized", e.getMessage());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
	}

}

