package com.example.sb.exception;

 public class EmployeeServiceException extends RuntimeException {
    public EmployeeServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}