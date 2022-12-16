package com.enigmacamp.employee.controller;

import com.enigmacamp.employee.exception.EntityExistException;
import com.enigmacamp.employee.exception.NotFoundException;
import com.enigmacamp.employee.exception.RestTemplateException;
import com.enigmacamp.employee.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(RestTemplateException.class)
    public ResponseEntity<ErrorResponse> handleRestTemplateException(RestTemplateException e) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ErrorResponse("X07", e.getMessage()));
    }

    @ExceptionHandler(EntityExistException.class)
    public ResponseEntity<ErrorResponse> handleEntityExistViolationException(EntityExistException e) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ErrorResponse("X03", e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgument(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> errors = new ArrayList<>();
        for (FieldError error : fieldErrors) {
            errors.add(error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("X02", errors.toString()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDataNotFoundException(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("X01", e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllException(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("X06", e.getMessage()));
    }
}
