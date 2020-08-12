package com.inoastrum.pharmaorderservice.web.mappers;

import com.inoastrum.pharmaorderservice.domain.Order;
import com.inoastrum.pharmaorderservice.web.model.OrderDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface OrderMapper {

    OrderDto orderToOrderDto(Order order);

    Order orderDtoToOrder(OrderDto orderDto);
}
