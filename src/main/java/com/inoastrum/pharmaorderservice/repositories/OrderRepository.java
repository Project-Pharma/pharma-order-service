package com.inoastrum.pharmaorderservice.repositories;

import com.inoastrum.pharmaorderservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
