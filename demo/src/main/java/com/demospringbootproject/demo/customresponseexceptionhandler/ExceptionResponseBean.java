package com.demospringbootproject.demo.customresponseexceptionhandler;

public class ExceptionResponseBean {

    private String message;

    public ExceptionResponseBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    
}
