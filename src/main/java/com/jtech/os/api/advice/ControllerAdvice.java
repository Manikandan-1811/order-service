package com.jtech.os.api.advice;

import com.jtech.os.api.exception.EmptyInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * Controller Advice for managing Global Exceptions
 * Annotated with {@link org.springframework.web.bind.annotation.ControllerAdvice @org.springframework.web.bind.annotation.ControllerAdvice}.
 *
 * @author Manikandan
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException e){
        return new ResponseEntity<>("Input Fields is Empty", HttpStatus.BAD_REQUEST);
    }
}
