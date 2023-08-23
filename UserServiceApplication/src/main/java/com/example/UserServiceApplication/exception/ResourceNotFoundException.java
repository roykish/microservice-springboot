package com.example.UserServiceApplication.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(ResourceNotFoundException exception){
        super("Resource Not Found In The Server.");
    }
    public ResourceNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
