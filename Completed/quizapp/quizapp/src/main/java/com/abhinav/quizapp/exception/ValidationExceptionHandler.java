package com.abhinav.quizapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<ObjectError> errors = result.getAllErrors();
        StringBuilder errorMessage = new StringBuilder("Validation failed. Errors: ");
        for (ObjectError error : errors) {
            errorMessage.append(error.getDefaultMessage()).append(" ");
        }
        return ResponseEntity.badRequest().body(errorMessage.toString());
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleCustomValidationException(ValidationException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
