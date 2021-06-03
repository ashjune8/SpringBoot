package com.demospringbootproject.demo.customresponseexceptionhandler;

import com.demospringbootproject.demo.userservice.UserException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseExceptionController extends ResponseEntityExceptionHandler{
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){

        ExceptionResponseBean exceptionResponse = new ExceptionResponseBean(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(UserException.class)
    public final ResponseEntity<Object> handleUserExceptions(Exception ex, WebRequest request){

        ExceptionResponseBean exceptionResponse = new ExceptionResponseBean(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        // TODO Auto-generated method stub
        ExceptionResponseBean exceptionResponse = new ExceptionResponseBean(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }


    


}
    

