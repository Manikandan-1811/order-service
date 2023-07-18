package com.jtech.os.api.exception;

import org.springframework.stereotype.Component;

@Component
public class EmptyInputException extends RuntimeException{
    private String errorCode;
    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public EmptyInputException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public EmptyInputException(){

    }
}
