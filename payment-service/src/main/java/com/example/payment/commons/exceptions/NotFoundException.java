package com.example.payment.commons.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String desc) {
        super(desc);
    }
}
