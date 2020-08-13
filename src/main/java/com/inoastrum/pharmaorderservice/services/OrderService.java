package com.inoastrum.pharmaorderservice.services;

import com.inoastrum.pharmaorderservice.domain.Order;

import java.util.UUID;

public interface OrderService {
    Order findOrderById(UUID orderId);
}
