package com.devsuperior.dscatalog.reosurces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.dto.DeliverRevisionDTO;
import com.devsuperior.dscatalog.service.DeliverRevisionService;

@RestController
@RequestMapping(value = "delivers")
public class DeliverResource {

	@Autowired
	private DeliverRevisionService service;
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> saveRevision(@PathVariable Long id, @RequestBody DeliverRevisionDTO dto){
		service.saveRevision(id, dto);
		return ResponseEntity.noContent().build();
		
	}
}
