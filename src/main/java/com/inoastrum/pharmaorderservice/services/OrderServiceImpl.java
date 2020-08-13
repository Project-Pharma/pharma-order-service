package com.inoastrum.pharmaorderservice.services;

import com.inoastrum.pharmaorderservice.domain.Order;
import com.inoastrum.pharmaorderservice.exceptions.OrderNotFoundException;
import com.inoastrum.pharmaorderservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order findOrderById(UUID orderId) {
        return orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
    }
}
