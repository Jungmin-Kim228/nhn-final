package com.springtour.hotel.exception;

public class UserIdNullException extends UserIdNotValidException {

    private static final String ERROR = "User Id 는 Null 일 수 없습니다.";

    public UserIdNullException() {
        super(ERROR);
    }

}
