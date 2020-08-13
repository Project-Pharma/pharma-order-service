package com.inoastrum.pharmaorderservice.services;

import com.inoastrum.pharmaorderservice.domain.Prescription;
import com.inoastrum.pharmaorderservice.web.model.PrescriptionDto;

import java.util.UUID;

public interface PrescriptionService {
    Prescription findPrescriptionById(UUID prescriptionId);

    PrescriptionDto findPrescriptionDtoById(UUID prescriptionId);
}
