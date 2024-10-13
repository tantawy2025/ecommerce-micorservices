package com.example.payment.commons.exceptions;

public class AlreadyExistsException extends IllegalArgumentException {

    public AlreadyExistsException(String desc) {
        super(desc);
    }

}

