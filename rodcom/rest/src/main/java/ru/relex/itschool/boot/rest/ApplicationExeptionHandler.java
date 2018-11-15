package ru.relex.itschool.boot.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author : sasha
 */
@ControllerAdvice
public class ApplicationExeptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIae (IllegalArgumentException e){
       return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
    }
}
