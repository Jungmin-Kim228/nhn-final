package com.springtour.hotel.controller;

import com.springtour.hotel.exception.UserIdNullException;

import java.util.Objects;

public class UserAuthzValidator {

    private static final Long VALID_USER_ID = 100L;

    public static Boolean isValid(Long userId) {
        if (Objects.isNull(userId))
            throw new UserIdNullException();

        return VALID_USER_ID.longValue() == userId.longValue();
    }

}
