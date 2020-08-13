package com.inoastrum.pharmaorderservice.web.mappers;

import com.inoastrum.pharmaorderservice.domain.Order;
import com.inoastrum.pharmaorderservice.web.model.OrderDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@DecoratedWith(OrderMapperDecorator.class)
@Mapper(uses = {DateMapper.class})
public interface OrderMapper {

    @Mapping(target = "prescriptionId", ignore = true)
    @Mapping(target = "deliveryDetailsId", ignore = true)
    OrderDto orderToOrderDto(Order order);

    @Mapping(target = "prescription", ignore = true)
    @Mapping(target = "deliveryDetails", ignore = true)
    Order orderDtoToOrder(OrderDto orderDto);
}
