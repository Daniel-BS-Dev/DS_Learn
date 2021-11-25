package com.devsuperior.dscatalog.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.dto.DeliverRevisionDTO;
import com.devsuperior.dscatalog.service.DeliverRevisionService;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverResource {

	@Autowired
	private DeliverRevisionService service;
	
	// essa anotações libera por metodo, ou seja so o admin e o inistructor podem enviar um deliver,
	//não posso esquecer e colocar a anotação na classe webSecurityConfigura para poder usar
	@PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> saveRevision(@PathVariable Long id, @RequestBody DeliverRevisionDTO dto){
		service.saveRevision(id, dto);
		return ResponseEntity.noContent().build();
		
	}
}
