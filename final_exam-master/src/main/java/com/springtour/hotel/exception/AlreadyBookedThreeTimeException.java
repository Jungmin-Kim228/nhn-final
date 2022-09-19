package com.springtour.hotel.exception;

public class AlreadyBookedThreeTimeException extends RuntimeException {

    private static final String ERROR = "이미 금일 3개의 객실을 예약하였습니다.";

    public AlreadyBookedThreeTimeException() {
        super(ERROR);
    }
}
