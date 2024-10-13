package com.example.discount_service.commons.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String desc) {
        super(desc);
    }
}
