package com.inoastrum.pharmaorderservice.repositories;

import com.inoastrum.pharmaorderservice.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PrescriptionRepository extends JpaRepository<Prescription, UUID> {

}
