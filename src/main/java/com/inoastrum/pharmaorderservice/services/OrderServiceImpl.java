package com.inoastrum.pharmaorderservice.services;

import com.inoastrum.pharmaorderservice.domain.DeliveryDetails;
import com.inoastrum.pharmaorderservice.domain.Order;
import com.inoastrum.pharmaorderservice.domain.Prescription;
import com.inoastrum.pharmaorderservice.exceptions.DeliveryDetailsNotFoundException;
import com.inoastrum.pharmaorderservice.exceptions.OrderNotFoundException;
import com.inoastrum.pharmaorderservice.exceptions.PrescriptionNotFoundException;
import com.inoastrum.pharmaorderservice.repositories.OrderRepository;
import com.inoastrum.pharmaorderservice.web.mappers.DeliveryDetailsMapper;
import com.inoastrum.pharmaorderservice.web.mappers.OrderMapper;
import com.inoastrum.pharmaorderservice.web.mappers.PrescriptionMapper;
import com.inoastrum.pharmaorderservice.web.model.DeliveryDetailsDto;
import com.inoastrum.pharmaorderservice.web.model.OrderDto;
import com.inoastrum.pharmaorderservice.web.model.PrescriptionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private OrderMapper orderMapper;
    private PrescriptionMapper prescriptionMapper;
    private DeliveryDetailsMapper deliveryDetailsMapper;

    @Autowired
    public void setDeliveryDetailsMapper(DeliveryDetailsMapper deliveryDetailsMapper) {
        this.deliveryDetailsMapper = deliveryDetailsMapper;
    }

    @Autowired
    public void setPrescriptionMapper(PrescriptionMapper prescriptionMapper) {
        this.prescriptionMapper = prescriptionMapper;
    }

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

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

    @Override
    public PrescriptionDto findPrescriptionDtoByOrderId(UUID orderId) {
        Prescription prescription = orderRepository.findById(orderId)
                .orElseThrow(OrderNotFoundException::new)
                .getPrescription();

        if (prescription == null)
            throw new PrescriptionNotFoundException();

        return prescriptionMapper.prescriptionToPrescriptionDto(prescription);
    }

    @Override
    public DeliveryDetailsDto findDeliveryDetailsDtoByOrderId(UUID orderId) {
        DeliveryDetails deliveryDetails = orderRepository.findById(orderId)
                .orElseThrow(OrderNotFoundException::new)
                .getDeliveryDetails();

        if (deliveryDetails == null)
            throw new DeliveryDetailsNotFoundException();

        return deliveryDetailsMapper.deliveryDetailsToDeliveryDetailsDto(deliveryDetails);
    }
}
