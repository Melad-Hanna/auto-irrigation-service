package com.banquemisr.autoirrigationservice.exception.custom;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
    private String message;
    private String debugMessage;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, String debugMessage) {
        super(message);
        this.debugMessage = debugMessage;
    }
}
