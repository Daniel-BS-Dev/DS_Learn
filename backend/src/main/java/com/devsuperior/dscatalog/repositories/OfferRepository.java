package com.devsuperior.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscatalog.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

}
