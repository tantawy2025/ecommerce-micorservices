package com.example.customer.commons.exceptions;

public class AlreadyExistsException extends IllegalArgumentException {

    public AlreadyExistsException(String desc) {
        super(desc);
    }

}

