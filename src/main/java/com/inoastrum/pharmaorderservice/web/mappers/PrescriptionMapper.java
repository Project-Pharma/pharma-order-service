package com.inoastrum.pharmaorderservice.web.mappers;

import com.inoastrum.pharmaorderservice.domain.Prescription;
import com.inoastrum.pharmaorderservice.web.model.PrescriptionDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface PrescriptionMapper {

    PrescriptionDto prescriptionToPrescriptionDto(Prescription prescription);

    Prescription prescriptionDtoToPrescription(PrescriptionDto prescriptionDto);
}
