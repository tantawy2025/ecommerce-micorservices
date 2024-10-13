package com.example.discount_service.commons.exceptions;

public class AlreadyExistsException extends IllegalArgumentException {

    public AlreadyExistsException(String desc) {
        super(desc);
    }

}

