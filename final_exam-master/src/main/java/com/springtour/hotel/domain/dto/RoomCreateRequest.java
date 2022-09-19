package com.springtour.hotel.domain.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class RoomCreateRequest {

    @NotBlank
    @Size(max = 100)
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
