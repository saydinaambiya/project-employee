package com.enigmacamp.employee.exception;

public class EntityExistException extends RuntimeException {
    public EntityExistException() {
        super("Data is Exist");
    }

    public EntityExistException(String message) {
        super(message);
    }
}
