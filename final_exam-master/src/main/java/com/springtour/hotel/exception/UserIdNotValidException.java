package com.springtour.hotel.exception;

public class UserIdNotValidException extends RuntimeException {

    public UserIdNotValidException(String s) {
        super(s);
    }

}
