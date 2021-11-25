package com.devsuperior.dscatalog.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscatalog.entities.Notification;
import com.devsuperior.dscatalog.entities.User;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
	// findByUser -> faz a busca de usuario como é uma busca paginada eu tenho que passa o pageable tambem
     Page<Notification> findByUser(User user, Pageable pageable);
}
