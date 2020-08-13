package com.inoastrum.pharmaorderservice.exceptions;

public class PrescriptionNotFoundException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Prescription you are looking for not found";
    }
}
