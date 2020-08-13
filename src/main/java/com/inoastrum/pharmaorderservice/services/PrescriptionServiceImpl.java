package com.inoastrum.pharmaorderservice.services;

import com.inoastrum.pharmaorderservice.domain.Prescription;
import com.inoastrum.pharmaorderservice.exceptions.PrescriptionNotFoundException;
import com.inoastrum.pharmaorderservice.repositories.PrescriptionRepository;
import com.inoastrum.pharmaorderservice.web.mappers.PrescriptionMapper;
import com.inoastrum.pharmaorderservice.web.model.PrescriptionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final PrescriptionMapper prescriptionMapper;

    @Override
    public Prescription findPrescriptionById(UUID prescriptionId) {
        return prescriptionRepository.findById(prescriptionId).orElseThrow(PrescriptionNotFoundException::new);
    }

    @Override
    public PrescriptionDto findPrescriptionDtoById(UUID prescriptionId) {
        return prescriptionMapper
                .prescriptionToPrescriptionDto(
                        prescriptionRepository.findById(prescriptionId)
                                .orElseThrow(PrescriptionNotFoundException::new));
    }

}
