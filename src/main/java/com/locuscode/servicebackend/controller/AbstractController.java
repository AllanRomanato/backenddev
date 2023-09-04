package com.locuscode.servicebackend.controller;

import com.locuscode.servicebackend.dto.ErrorDto;
import com.locuscode.servicebackend.exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class AbstractController {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDto>badRequestHandler(BadRequestException exception){
        return new ResponseEntity<>(new ErrorDto(1,exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
