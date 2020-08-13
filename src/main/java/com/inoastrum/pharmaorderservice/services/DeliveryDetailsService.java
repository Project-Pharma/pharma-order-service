package com.inoastrum.pharmaorderservice.services;

import com.inoastrum.pharmaorderservice.domain.DeliveryDetails;

import java.util.UUID;

public interface DeliveryDetailsService {
    DeliveryDetails findDeliveryDetailsById(UUID deliveryDetailsId);
}
