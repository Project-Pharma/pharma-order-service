package com.inoastrum.pharmaorderservice.services;

import com.inoastrum.pharmaorderservice.domain.DeliveryDetails;
import com.inoastrum.pharmaorderservice.exceptions.DeliveryDetailsNotFoundException;
import com.inoastrum.pharmaorderservice.repositories.DeliveryDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DeliveryDetailsServiceImpl implements DeliveryDetailsService {

    private final DeliveryDetailsRepository deliveryDetailsRepository;

    @Override
    public DeliveryDetails findDeliveryDetailsById(UUID deliveryDetailsId) {
        return deliveryDetailsRepository.findById(deliveryDetailsId).orElseThrow(DeliveryDetailsNotFoundException::new);
    }
}
