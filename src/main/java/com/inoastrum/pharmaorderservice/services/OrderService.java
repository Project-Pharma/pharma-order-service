package com.inoastrum.pharmaorderservice.services;

import com.inoastrum.pharmaorderservice.domain.Order;
import com.inoastrum.pharmaorderservice.web.model.OrderDto;

import java.util.UUID;

public interface OrderService {
    Order findOrderById(UUID orderId);

    OrderDto findOrderDtoById(UUID orderId);

    OrderDto createNewOrder(OrderDto orderDto);

    void updateOrder(UUID orderId, OrderDto orderDto);

    void deleteOrderById(UUID orderId);
}
