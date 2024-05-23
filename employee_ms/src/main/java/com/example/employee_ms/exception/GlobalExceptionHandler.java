package com.example.employee_ms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<String> IdNotFoundExceptionHandler(IdNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getErrMsg());
    }

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<String> DuplicateEntryExceptionHandler(DuplicateEntryException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getErrMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception){
        HashMap<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return errors;
    }


}
