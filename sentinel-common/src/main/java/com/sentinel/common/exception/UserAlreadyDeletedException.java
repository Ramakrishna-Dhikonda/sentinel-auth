package com.sentinel.common.exception;

public class UserAlreadyDeletedException extends RuntimeException {

    public UserAlreadyDeletedException(String message) {
        super(message);
    }
}
