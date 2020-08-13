package com.inoastrum.pharmaorderservice.web.mappers;

import com.inoastrum.pharmaorderservice.domain.DeliveryDetails;
import com.inoastrum.pharmaorderservice.web.model.DeliveryDetailsDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@DecoratedWith(DeliveryDetailsMapperDecorator.class)
@Mapper(uses = {DateMapper.class})
public interface DeliveryDetailsMapper {

    @Mapping(target = "orderId", ignore = true)
    DeliveryDetailsDto deliveryDetailsToDeliveryDetailsDto(DeliveryDetails deliveryDetails);

    @Mapping(target = "order", ignore = true)
    DeliveryDetails deliveryDetailsDtoToDeliveryDetails(DeliveryDetailsDto deliveryDetailsDto);

}
