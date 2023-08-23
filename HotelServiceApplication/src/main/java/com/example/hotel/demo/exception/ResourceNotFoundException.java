package com.example.hotel.demo.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String errorMessage) {
        super(errorMessage);
    }
    public ResourceNotFoundException(){
        super("Resource not found.");
    }
}
