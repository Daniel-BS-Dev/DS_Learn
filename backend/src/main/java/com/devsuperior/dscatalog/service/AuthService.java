package com.devsuperior.dscatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.entities.User;
import com.devsuperior.dscatalog.repositories.UserRepository;
import com.devsuperior.dscatalog.services.exceptions.Forbidden;
import com.devsuperior.dscatalog.services.exceptions.Unauthorized;

@Service
public class AuthService {

	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public User authenticated() {
		
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return repository.findByEmail(username);
		}catch(Exception e) {
		  throw new Unauthorized("Invalid user");	
		}
	}
	
	public void ValidateSelfOrAdmin(Long userId) {
		User user = authenticated();
		if(!user.getId().equals(userId) && (!user.hasRole("Role_Admin"))){
			throw new Forbidden("acess denied");
		}
	}
}
