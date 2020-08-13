package com.inoastrum.pharmaorderservice.exceptions;

public class OrderNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Order you are looking for not found";
    }
}
