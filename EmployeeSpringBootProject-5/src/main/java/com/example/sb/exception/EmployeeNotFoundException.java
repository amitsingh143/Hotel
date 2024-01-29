package com.example.sb.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

//public class EmployeeNotFoundException extends RuntimeException {
//    public EmployeeNotFoundException(String message) {
//        super(message);
//    }
//}

   