package com.inoastrum.pharmaorderservice.services;

import com.inoastrum.pharmaorderservice.domain.DeliveryDetails;
import com.inoastrum.pharmaorderservice.web.model.DeliveryDetailsDto;

import java.util.UUID;

public interface DeliveryDetailsService {
    DeliveryDetails findDeliveryDetailsById(UUID deliveryDetailsId);

    DeliveryDetailsDto findDeliveryDetailsDtoById(UUID deliveryDetailsId);

    DeliveryDetailsDto createNewDeliveryDetails(DeliveryDetailsDto deliveryDetailsDto);

    void updateDeliveryDetails(UUID deliveryDetailsId, DeliveryDetailsDto deliveryDetailsDto);
}
