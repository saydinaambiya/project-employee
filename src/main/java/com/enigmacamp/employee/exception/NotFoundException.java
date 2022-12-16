package com.enigmacamp.employee.exception;

public class NotFoundException extends  RuntimeException{
    public NotFoundException() {
        super("Data is Not Found");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
