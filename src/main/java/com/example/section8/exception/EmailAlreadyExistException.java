package com.example.section8.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistException extends RuntimeException {
    public String message;

    public EmailAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
}
