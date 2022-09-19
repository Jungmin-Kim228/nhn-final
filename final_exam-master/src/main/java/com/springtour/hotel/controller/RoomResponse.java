package com.springtour.hotel.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomResponse {

    private String id;

    private String name;

    private Integer capacity;

    private Integer floor;

    private boolean hasBathtub;

    private String viewType;

    private String createdAt;

}
