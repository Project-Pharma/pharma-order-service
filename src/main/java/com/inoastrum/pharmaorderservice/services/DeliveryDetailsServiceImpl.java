package com.inoastrum.pharmaorderservice.services;

import com.inoastrum.pharmaorderservice.domain.DeliveryDetails;
import com.inoastrum.pharmaorderservice.exceptions.DeliveryDetailsNotFoundException;
import com.inoastrum.pharmaorderservice.repositories.DeliveryDetailsRepository;
import com.inoastrum.pharmaorderservice.web.mappers.DeliveryDetailsMapper;
import com.inoastrum.pharmaorderservice.web.model.DeliveryDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DeliveryDetailsServiceImpl implements DeliveryDetailsService {

    private final DeliveryDetailsRepository deliveryDetailsRepository;

    private DeliveryDetailsMapper deliveryDetailsMapper;

    @Autowired
    public void setDeliveryDetailsMapper(DeliveryDetailsMapper deliveryDetailsMapper) {
        this.deliveryDetailsMapper = deliveryDetailsMapper;
    }

    @Override
    public DeliveryDetails findDeliveryDetailsById(UUID deliveryDetailsId) {
        return deliveryDetailsRepository.findById(deliveryDetailsId).orElseThrow(DeliveryDetailsNotFoundException::new);
    }

    @Override
    public DeliveryDetailsDto findDeliveryDetailsDtoById(UUID deliveryDetailsId) {
        return deliveryDetailsMapper.deliveryDetailsToDeliveryDetailsDto(
                deliveryDetailsRepository.findById(deliveryDetailsId)
                        .orElseThrow(DeliveryDetailsNotFoundException::new));
    }

    @Override
    public DeliveryDetailsDto createNewDeliveryDetails(DeliveryDetailsDto deliveryDetailsDto) {
        return deliveryDetailsMapper.deliveryDetailsToDeliveryDetailsDto(
                deliveryDetailsRepository.save(
                        deliveryDetailsMapper.deliveryDetailsDtoToDeliveryDetails(deliveryDetailsDto)
                )
        );
    }

    @Override
    public void updateDeliveryDetails(UUID deliveryDetailsId, DeliveryDetailsDto deliveryDetailsDto) {
        DeliveryDetails deliveryDetails = deliveryDetailsRepository
                .findById(deliveryDetailsId)
                .orElseThrow(DeliveryDetailsNotFoundException::new);

        deliveryDetails.setName(deliveryDetailsDto.getName());
        deliveryDetails.setAddress(deliveryDetailsDto.getAddress());
        deliveryDetails.setProvinceId(deliveryDetailsDto.getProvinceId());
        deliveryDetails.setDistrictId(deliveryDetailsDto.getDistrictId());
        deliveryDetails.setPhoneNumber(deliveryDetailsDto.getPhoneNumber());

        deliveryDetailsRepository.save(deliveryDetails);
    }
}
