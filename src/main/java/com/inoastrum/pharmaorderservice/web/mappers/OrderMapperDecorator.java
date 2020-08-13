package com.inoastrum.pharmaorderservice.web.mappers;

import com.inoastrum.pharmaorderservice.domain.Order;
import com.inoastrum.pharmaorderservice.services.DeliveryDetailsService;
import com.inoastrum.pharmaorderservice.services.PrescriptionService;
import com.inoastrum.pharmaorderservice.web.model.OrderDto;
import com.inoastrum.pharmaorderservice.web.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OrderMapperDecorator implements OrderMapper {

    private OrderMapper delegate;
    private PrescriptionService prescriptionService;
    private DeliveryDetailsService deliveryDetailsService;

    @Autowired
    public void setDelegate(OrderMapper delegate) {
        this.delegate = delegate;
    }

    @Autowired
    public void setDeliveryDetailsService(DeliveryDetailsService deliveryDetailsService) {
        this.deliveryDetailsService = deliveryDetailsService;
    }

    @Autowired
    public void setPrescriptionService(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @Override
    public OrderDto orderToOrderDto(Order order) {
        OrderDto dto = delegate.orderToOrderDto(order);

        if (order.getPrescription() != null)
            dto.setPrescriptionId(order.getPrescription().getId());

        if (order.getDeliveryDetails() != null)
            dto.setDeliveryDetailsId(order.getDeliveryDetails().getId());

        return dto;
    }

    @Override
    public Order orderDtoToOrder(OrderDto orderDto) {
        if (orderDto.getOrderStatus() == null) {
            orderDto.setOrderStatus(OrderStatus.ORDER_CREATED);
        }

        Order order = delegate.orderDtoToOrder(orderDto);

        if (orderDto.getPrescriptionId() != null)
            order.setPrescription(prescriptionService.findPrescriptionById(orderDto.getPrescriptionId()));

        if (orderDto.getDeliveryDetailsId() != null)
            order.setDeliveryDetails(deliveryDetailsService.findDeliveryDetailsById(orderDto.getDeliveryDetailsId()));

        return order;
    }
}
