package com.springtour.hotel.domain.dto;

import com.springtour.hotel.domain.Room;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomResponse {

    private String id;

    private String name;

    private Integer capacity;

    private Integer floor;

    private Boolean hasBathtub;

    private String viewType;

    private String createdAt;

    public RoomResponse(Room room) {
        this.id = String.valueOf(room.getId());
        this.name = room.getName();
        this.capacity = room.getCapacity();
        this.floor = room.getFloor();
        this.hasBathtub = room.isBathtubFlag();
        this.viewType = room.getViewType().getParameter();
        this.createdAt = String.valueOf(room.getCreatedAt());
    }

    public void changeTimeFormat(String createdAt) {
        this.createdAt = createdAt;
    }

}
