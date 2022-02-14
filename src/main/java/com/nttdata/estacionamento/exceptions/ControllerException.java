package com.nttdata.estacionamento.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerException extends RuntimeException{

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandarError> NotFoundException(NotFoundException e, HttpServletRequest request){
        StandarError err = new StandarError(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
    @ExceptionHandler(ProcessException.class)
    public ResponseEntity<StandarError> InProcessException(ProcessException e, HttpServletRequest request){
        StandarError err = new StandarError(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
