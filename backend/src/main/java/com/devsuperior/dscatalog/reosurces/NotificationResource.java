package com.devsuperior.dscatalog.reosurces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.dto.NotificationDTO;
import com.devsuperior.dscatalog.service.NotificationService;

@RestController
@RequestMapping(value="/notifications")
public class NotificationResource {
	
	@Autowired
	private NotificationService service;
	
	@GetMapping
	public ResponseEntity<Page<NotificationDTO>> findById(Pageable pageable){
		Page<NotificationDTO> entity = service.notificationForCurrentUser(pageable);
		return ResponseEntity.ok().body(entity);
	}

}
