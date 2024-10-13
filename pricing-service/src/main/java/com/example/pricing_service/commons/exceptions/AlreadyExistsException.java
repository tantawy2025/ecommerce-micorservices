package com.example.pricing_service.commons.exceptions;

public class AlreadyExistsException extends IllegalArgumentException {

    public AlreadyExistsException(String desc) {
        super(desc);
    }

}

