package com.inoastrum.pharmaorderservice.web.model;

public enum OrderStatus {
    ORDER_CREATED,
    PRESCRIPTION_WAITING_FOR_APPROVAL,
    PRESCRIPTION_DISAPPROVED,
    PRESCRIPTION_APPROVED,
    ORDER_SENT,
    ORDER_CANCELLED,
    ORDER_SUCCESS,

}
