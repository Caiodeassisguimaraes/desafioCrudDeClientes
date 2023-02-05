package com.desafiocruddeclientes.DesafioCrudDeClientes.controllers.handlers;

import com.desafiocruddeclientes.DesafioCrudDeClientes.dto.CustomError;
import com.desafiocruddeclientes.DesafioCrudDeClientes.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException error, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), error.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}