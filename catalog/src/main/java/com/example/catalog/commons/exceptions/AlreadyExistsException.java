package com.example.catalog.commons.exceptions;

public class AlreadyExistsException extends IllegalArgumentException {

    public AlreadyExistsException(String desc) {
        super(desc);
    }

}

