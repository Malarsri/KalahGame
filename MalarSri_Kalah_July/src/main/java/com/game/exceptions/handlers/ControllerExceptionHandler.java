package com.game.exceptions.handlers;

import com.game.model.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 This class provides general Exception handling for our REST API. This helps better user experience in general
 */
@RestControllerAdvice
public class ControllerExceptionHandler {
    /**
     Exception Handler

     @param ex - exception of type Exception
     @return Error Model with code and error message of the exception
     */
    @ExceptionHandler(Exception.class)
    private ResponseEntity<Error> handleResourceNotFoundException(Exception ex) {
        return ResponseEntity.badRequest().body(Error.from(ex));
    }
}
