package com.springtour.hotel.domain.dto;

import lombok.Getter;

@Getter
public class RoomCreateRequest {

    private String name;
    private Integer capacity;
    private Integer floor;
    private boolean hasBathtub;
    private String viewType;

}
