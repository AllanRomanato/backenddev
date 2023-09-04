package com.locuscode.servicebackend.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BadRequestException extends RuntimeException{
    public BadRequestException(String msg) {
        super(msg);
    }
    public BadRequestException(Throwable t) {
        super(t);
    }
    public BadRequestException(String msg, Throwable t) {
        super(msg, t);
    }
}
