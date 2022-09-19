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

    @Override
    public List<RoomResponse> findByHotelId(Long hotelId) {
        QRoom room = QRoom.room;

        return from(room)
                .where(room.hotel.id.eq(hotelId))
                .select(Projections.constructor(RoomResponse.class,
                                                room.id,
                                                room.name,
                                                room.capacity,
                                                room.floor,
                                                room.bathtubFlag,
                                                room.viewType,
                                                room.createdAt))
                .fetch();
    }
}
