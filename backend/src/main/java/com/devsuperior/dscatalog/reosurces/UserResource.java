package com.devsuperior.dscatalog.reosurces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.dto.UserDTO;
import com.devsuperior.dscatalog.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<UserDTO> findById(@PathVariable Long id){
		UserDTO entity= service.findAll(id);
		return ResponseEntity.ok().body(entity);
	}

}
