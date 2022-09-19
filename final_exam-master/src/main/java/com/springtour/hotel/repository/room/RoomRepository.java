package com.springtour.hotel.repository.room;

import com.springtour.hotel.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long>, RoomRepositoryCustom {

    List<Room> findRoomsByHotel_Id(Long hotelId);

}
