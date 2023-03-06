package com.sda.study.springbootpractice.exceptions;

public class SchoolAlreadyExistsException extends Exception {

    private static final long serialVersionUID = 1L;

    public SchoolAlreadyExistsException(String name) {
        super(String.format("School already exists with name: %s", name));
    }
}


