package com.springtour.hotel.exception;

public class AlreadyBookedException extends RuntimeException {

    private static final String ERROR = "이미 예약된 객실입니다.";

    public AlreadyBookedException() {
        super(ERROR);
    }

}
