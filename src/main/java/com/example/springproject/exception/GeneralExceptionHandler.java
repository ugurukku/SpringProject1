package com.example.springproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public  ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex){
        UserExceptionDetails userExceptionDetails = new UserExceptionDetails(LocalDateTime.now(),
                ex.getBindingResult().getFieldError().getDefaultMessage(),
                "");
        return new ResponseEntity<>(userExceptionDetails, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public  ResponseEntity<Object> handleeException(Exception ex, WebRequest request) throws Exception{
         UserExceptionDetails userExceptionDetails= new UserExceptionDetails(LocalDateTime.now(),
                 ex.getMessage(),
                 request.getDescription(false));
            return new ResponseEntity(userExceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
