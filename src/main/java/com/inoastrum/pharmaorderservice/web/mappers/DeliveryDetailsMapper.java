package com.inoastrum.pharmaorderservice.web.mappers;

import com.inoastrum.pharmaorderservice.domain.DeliveryDetails;
import com.inoastrum.pharmaorderservice.web.model.DeliveryDetailsDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface DeliveryDetailsMapper {

    DeliveryDetailsDto deliveryDetailsToDeliveryDetailsDto(DeliveryDetails deliveryDetails);

    DeliveryDetails deliveryDetailsDtoToDeliveryDetails(DeliveryDetailsDto deliveryDetailsDto);

}
