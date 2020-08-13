package com.inoastrum.pharmaorderservice.exceptions;

public class DeliveryDetailsNotFoundException extends RuntimeException{

    @Override
    public String getMessage() {
        return "DeliveryDetails you are looking for are not found";
    }
}
