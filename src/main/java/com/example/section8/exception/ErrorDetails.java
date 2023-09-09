package com.example.section8.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    //contain error message when an exception is caught

    private LocalDateTime timestamp;
    private String message;
    private String path;
    private String errorCode;
}
