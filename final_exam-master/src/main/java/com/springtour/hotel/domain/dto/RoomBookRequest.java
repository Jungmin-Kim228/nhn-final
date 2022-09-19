package com.springtour.hotel.domain.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class RoomBookRequest {

    private Long userId;

    @NotNull
    private LocalDate checkIn;

    @NotNull
    private LocalDate checkOut;

}
