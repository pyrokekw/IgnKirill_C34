package org.spring.web.exc;

public class UserProcessingException extends RuntimeException {
    public UserProcessingException(String message) {
        super(message);
    }
}