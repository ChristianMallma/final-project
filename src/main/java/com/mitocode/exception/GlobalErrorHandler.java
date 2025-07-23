package com.mitocode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleModelNotFoundException(ModelNotFoundException ex, WebRequest request) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(LocalDateTime.now(),
                                                                          ex.getMessage(),
                                                                          request.getDescription(false));

        return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
    }
}
