package com.springtour.hotel.exception;

public class HotelNotFoundException extends RuntimeException {

    private static final String ERROR = "호텔을 찾을 수 없습니다.";

    public HotelNotFoundException() {
        super(ERROR);
    }

}
