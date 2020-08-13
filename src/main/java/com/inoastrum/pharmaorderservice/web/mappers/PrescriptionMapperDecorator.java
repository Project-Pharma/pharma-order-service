package com.inoastrum.pharmaorderservice.web.mappers;

import com.inoastrum.pharmaorderservice.domain.Prescription;
import com.inoastrum.pharmaorderservice.services.OrderService;
import com.inoastrum.pharmaorderservice.web.model.PrescriptionDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class PrescriptionMapperDecorator implements PrescriptionMapper {
    private PrescriptionMapper delegate;
    private OrderService orderService;

    @Autowired
    public void setDelegate(PrescriptionMapper delegate) {
        this.delegate = delegate;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public PrescriptionDto prescriptionToPrescriptionDto(Prescription prescription) {
        PrescriptionDto dto = delegate.prescriptionToPrescriptionDto(prescription);

        dto.setEPrescriptionNo(prescription.getEPrescriptionNo());
        dto.setOrderId(prescription.getOrder().getId());

        return dto;
    }

    @Override
    public Prescription prescriptionDtoToPrescription(PrescriptionDto prescriptionDto) {
        Prescription prescription = delegate.prescriptionDtoToPrescription(prescriptionDto);

        prescription.setEPrescriptionNo(prescriptionDto.getEPrescriptionNo());
        prescription.setOrder(orderService.findOrderById(prescriptionDto.getOrderId()));

        return prescription;
    }
}
