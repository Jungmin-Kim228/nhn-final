package com.springtour.hotel.converter;

import java.time.LocalDateTime;

public interface TimeFormatter {

    static String convert(LocalDateTime localDateTime) {
        return String.valueOf(localDateTime);
    }

}
