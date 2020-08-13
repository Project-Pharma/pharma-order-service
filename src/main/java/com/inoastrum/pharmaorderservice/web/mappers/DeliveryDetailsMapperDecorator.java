package com.inoastrum.pharmaorderservice.web.mappers;

import com.inoastrum.pharmaorderservice.domain.DeliveryDetails;
import com.inoastrum.pharmaorderservice.services.OrderService;
import com.inoastrum.pharmaorderservice.web.model.DeliveryDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class DeliveryDetailsMapperDecorator implements DeliveryDetailsMapper{
    private DeliveryDetailsMapper delegate;
    private OrderService orderService;

    @Autowired
    public void setDelegate(DeliveryDetailsMapper delegate) {
        this.delegate = delegate;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public DeliveryDetailsDto deliveryDetailsToDeliveryDetailsDto(DeliveryDetails deliveryDetails) {
        DeliveryDetailsDto dto = delegate.deliveryDetailsToDeliveryDetailsDto(deliveryDetails);

        dto.setOrderId(deliveryDetails.getOrder().getId());

        return dto;
    }

    @Override
    public DeliveryDetails deliveryDetailsDtoToDeliveryDetails(DeliveryDetailsDto deliveryDetailsDto) {
        DeliveryDetails deliveryDetails = delegate.deliveryDetailsDtoToDeliveryDetails(deliveryDetailsDto);

        deliveryDetails.setOrder(orderService.findOrderById(deliveryDetailsDto.getOrderId()));

        return deliveryDetails;
    }
}
