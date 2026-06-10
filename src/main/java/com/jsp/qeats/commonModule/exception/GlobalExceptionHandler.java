package com.jsp.qeats.commonModule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorResponseStructure> handleUserException(UserException userException) {
        ErrorResponseStructure error = new ErrorResponseStructure();
        error.setStatuscode(404);
        error.setMessage(userException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseStructure> handleException(Exception exception) {
        ErrorResponseStructure error = new ErrorResponseStructure();
        error.setStatuscode(500);
        error.setMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
