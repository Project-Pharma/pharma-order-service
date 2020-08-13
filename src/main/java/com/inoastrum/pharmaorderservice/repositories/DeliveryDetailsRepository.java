package com.inoastrum.pharmaorderservice.repositories;

import com.inoastrum.pharmaorderservice.domain.DeliveryDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeliveryDetailsRepository extends JpaRepository<DeliveryDetails, UUID> {
}
