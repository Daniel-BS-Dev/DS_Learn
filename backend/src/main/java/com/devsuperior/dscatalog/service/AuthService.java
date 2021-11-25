package com.devsuperior.dscatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.entities.User;
import com.devsuperior.dscatalog.repositories.UserRepository;
import com.devsuperior.dscatalog.services.exceptions.ForbiddenException;
import com.devsuperior.dscatalog.services.exceptions.UnauthorizedException;

@Service
public class AuthService {

	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public User authenticated() {
		
		// esse try é se caso usuario não exista
		try {
			// pegando o usuario que ja foi reconhecido pelo security
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return repository.findByEmail(username);// retorna esse usuario
		}catch(Exception e) {
		  throw new UnauthorizedException("Invalid user");	
		}
	}
	
	// metodo para verificar se o id passado na uri é do usuario o do proprio usuario, vou usar esse metodo no service
	public void ValidateSelfOrAdmin(Long userId) {
		User user = authenticated();// peguei o usuario autenticado
		if(!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")){
			throw new ForbiddenException("access denied");
		}
	}
}
