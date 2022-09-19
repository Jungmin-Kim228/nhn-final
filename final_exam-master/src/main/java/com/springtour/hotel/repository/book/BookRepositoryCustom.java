package com.springtour.hotel.repository.book;

import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDate;

@NoRepositoryBean
public interface BookRepositoryCustom {

    boolean isAlreadyBooked(Long roomId, LocalDate checkIn, LocalDate checkOut);

    Long isAlreadyBookedThreeTimes(Long userId);

}
