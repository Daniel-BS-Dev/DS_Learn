package com.devsuperior.dscatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.DeliverRevisionDTO;
import com.devsuperior.dscatalog.entities.Deliver;
import com.devsuperior.dscatalog.repositories.DeliverRepository;

@Service
public class DeliverRevisionService {
	
	@Autowired 
	private DeliverRepository repository;
	
	@Transactional
	public void saveRevision(Long id, DeliverRevisionDTO dto) {
		Deliver entity = repository.getOne(id);
		entity.setStatus(dto.getStatus());
		entity.setFeedback(dto.getFeedback());
		entity.setCorrectorCount(dto.getCorrectCount());
	    entity = repository.save(entity);
		
	}

}
