package com.inoastrum.pharmaorderservice.services;

import com.inoastrum.pharmaorderservice.domain.Order;
import com.inoastrum.pharmaorderservice.exceptions.OrderNotFoundException;
import com.inoastrum.pharmaorderservice.repositories.OrderRepository;
import com.inoastrum.pharmaorderservice.web.mappers.OrderMapper;
import com.inoastrum.pharmaorderservice.web.model.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public Order findOrderById(UUID orderId) {
        return orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
    }

    @Override
    public OrderDto findOrderDtoById(UUID orderId) {
        return orderMapper.orderToOrderDto(orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new));
    }

    @Override
    public OrderDto createNewOrder(OrderDto orderDto) {
        return orderMapper.orderToOrderDto(orderRepository.save(orderMapper.orderDtoToOrder(orderDto)));
    }

    @Override
    public void updateOrder(UUID orderId, OrderDto orderDto) {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);

        order.setOwnerId(orderDto.getOwnerId());
        order.setPharmacyId(orderDto.getPharmacyId());
        if (orderDto.getOrderStatus() != null)
            order.setOrderStatus(orderDto.getOrderStatus().toString());

        orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(UUID orderId) {
        orderRepository.deleteById(orderId);
    }
}
