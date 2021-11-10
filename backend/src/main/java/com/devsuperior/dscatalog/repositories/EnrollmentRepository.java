package com.devsuperior.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscatalog.entities.Enrollment;
import com.devsuperior.dscatalog.entities.pk.EnrollmentPk;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPk> {

}
