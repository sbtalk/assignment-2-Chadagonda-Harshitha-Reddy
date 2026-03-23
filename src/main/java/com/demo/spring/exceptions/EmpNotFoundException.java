package com.demo.spring.exceptions;

public class EmpNotFoundException extends EmpResourceException {
    EmpNotFoundException(){}
    public EmpNotFoundException(String message){
        super(message);
    }
}
