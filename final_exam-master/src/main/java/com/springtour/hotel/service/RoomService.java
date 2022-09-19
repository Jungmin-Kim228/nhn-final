package com.springtour.hotel.service;

import com.springtour.hotel.controller.RoomResponse;
import com.springtour.hotel.domain.Room;
import com.springtour.hotel.repository.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    // RoomResponse 클래스는 Room Entity 객체를 클라이언트에게 응답하기 위한 DTO 입니다.
    // 객실 정보 조회 API 명세서의 Response 양식을 보시고 적절한 형태로 RoomResponse 클래스를 만들어주세요.
    // JSON message 의 viewType 속성은 미리 제공한 ViewType enum의 parameter 값을 사용해야 합니다.
    // Hint. javax.persistence.AttributeConverter 인터페이스와 @Convert 애너테이션을 사용하면 됩니다.
    @Transactional(readOnly = true)
    public List<RoomResponse> getRoomsByHotelId(Long hotelId) {
        List<RoomResponse> roomResponseList = new ArrayList<>();
        List<Room> roomList = roomRepository.findRoomsByHotel_Id(hotelId);

        for (Room room : roomList) {
            roomResponseList.add(new RoomResponse(room));
        }

        return roomResponseList;
    }

}
