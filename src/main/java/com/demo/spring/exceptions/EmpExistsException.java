package com.demo.spring.exceptions;

public class EmpExistsException extends EmpResourceException {
    EmpExistsException(){}
    public EmpExistsException(String message){
        super(message);
    }
}
