package com.microservices.employeeservice.exception;


public class CustomNullValueException extends RuntimeException {
	
    public CustomNullValueException(String message) {
        super(message);
    }
}
