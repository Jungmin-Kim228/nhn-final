package com.springtour.hotel.exception;

public class RoomNotFoundException extends NotFoundException {

    private static final String ERROR = "객실을 찾을 수 없습니다.";

    public RoomNotFoundException() {
        super(ERROR);
    }
}
