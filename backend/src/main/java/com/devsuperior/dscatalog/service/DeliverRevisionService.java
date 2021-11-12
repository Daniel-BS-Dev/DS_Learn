package com.devsuperior.dscatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dscatalog.dto.DeliverRevisionDTO;
import com.devsuperior.dscatalog.entities.Deliver;
import com.devsuperior.dscatalog.repositories.DeliverRepository;

@Service
public class DeliverRevisionService {
	
	@Autowired 
	private DeliverRepository repository;
	
	public void saveRevision(Long id, DeliverRevisionDTO dto) {
		Deliver entity = new Deliver();
		entity.setCorrectorCount(dto.getCorrectCount());
		entity.setStatus(dto.getStatus());
		entity.setFeedback(dto.getFeedback());
		entity.setMoment(dto.getMoment());
		entity= repository.save(entity);
		
	}

}
