package com.example.pricing_service.commons.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String desc) {
        super(desc);
    }
}
