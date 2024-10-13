package com.example.customer.commons.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String desc) {
        super(desc);
    }
}
