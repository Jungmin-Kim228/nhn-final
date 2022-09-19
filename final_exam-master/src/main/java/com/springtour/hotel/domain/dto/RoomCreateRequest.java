package com.springtour.hotel.domain.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class RoomCreateRequest {

    @NotBlank
    private String name;

    @NotNull
    private Integer capacity;

    @NotNull
    private Integer floor;

    @NotNull
    private boolean hasBathtub;

    @NotBlank
    private String viewType;

}
