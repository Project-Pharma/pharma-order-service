package com.inoastrum.pharmaorderservice.web.mappers;

import com.inoastrum.pharmaorderservice.domain.Prescription;
import com.inoastrum.pharmaorderservice.web.model.PrescriptionDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@DecoratedWith(PrescriptionMapperDecorator.class)
@Mapper(uses = {DateMapper.class})
public interface PrescriptionMapper {

    @Mapping(target = "orderId", ignore = true)
    @Mapping(target = "ePrescriptionNo", ignore = true)
    PrescriptionDto prescriptionToPrescriptionDto(Prescription prescription);

    @Mapping(target = "order", ignore = true)
    @Mapping(target = "ePrescriptionNo", ignore = true)
    Prescription prescriptionDtoToPrescription(PrescriptionDto prescriptionDto);
}
