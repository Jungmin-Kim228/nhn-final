package com.springtour.hotel.controller;

import com.springtour.hotel.domain.Room;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RoomResponse {

    private String id;

    private String name;

    private Integer capacity;

    private Integer floor;

    private Boolean hasBathtub;

    private String viewType;

    private LocalDateTime createdAt;

    public RoomResponse(Room room) {
        this.id = String.valueOf(room.getId());
        this.name = room.getName();
        this.capacity = room.getCapacity();
        this.floor = room.getFloor();
        this.hasBathtub = room.isBathtubFlag();
        this.viewType = room.getViewType().getParameter();
        this.createdAt = room.getCreatedAt();
    }

}
