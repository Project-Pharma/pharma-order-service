package com.inoastrum.pharmaorderservice.services;

import com.inoastrum.pharmaorderservice.domain.Prescription;

import java.util.UUID;

public interface PrescriptionService {
    Prescription findPrescriptionById(UUID prescriptionId);
}
