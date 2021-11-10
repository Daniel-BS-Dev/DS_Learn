package com.devsuperior.dscatalog.service;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.UserDTO;
import com.devsuperior.dscatalog.entities.User;
import com.devsuperior.dscatalog.repositories.UserRepository;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;

import ch.qos.logback.classic.Logger;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = (Logger) LoggerFactory.getLogger(UserService.class);	
	
	@Autowired
	private UserRepository repository;
	
	
	@Transactional(readOnly=true)
	public UserDTO findAll(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Id not found"));
		return new UserDTO(entity);
	}
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repository.findByEmail(username);
		
		if(user == null) {
			logger.error("user not found ", username);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info("User found " + username);
		return user;
	}

	

}
