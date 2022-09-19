package com.springtour.hotel.repository.room;

import com.springtour.hotel.domain.Room;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class RoomRepositoryImpl extends QuerydslRepositorySupport implements RoomRepositoryCustom{

    public RoomRepositoryImpl() {
        super(Room.class);
    }
    
}
