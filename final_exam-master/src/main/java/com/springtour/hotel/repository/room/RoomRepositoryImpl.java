package com.springtour.hotel.repository.room;

import com.querydsl.core.types.Projections;
import com.springtour.hotel.controller.RoomResponse;
import com.springtour.hotel.domain.QRoom;
import com.springtour.hotel.domain.Room;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class RoomRepositoryImpl extends QuerydslRepositorySupport implements RoomRepositoryCustom{

    public RoomRepositoryImpl() {
        super(Room.class);
    }
    
}
