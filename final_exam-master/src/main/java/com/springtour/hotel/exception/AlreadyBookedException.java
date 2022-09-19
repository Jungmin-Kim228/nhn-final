package com.springtour.hotel.exception;

public class AlreadyBookedException extends RuntimeException {

    public AlreadyBookedException(String s) {
        super(s);
    }

}
