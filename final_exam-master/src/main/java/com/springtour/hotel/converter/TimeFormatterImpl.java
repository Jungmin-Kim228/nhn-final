package com.springtour.hotel.converter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeFormatterImpl implements TimeFormatter {

    @Value("${date.format}")
    private String pattern;
    @Override
    public String convert(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

}
