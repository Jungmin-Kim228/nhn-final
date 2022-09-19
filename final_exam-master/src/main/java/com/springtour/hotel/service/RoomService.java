package com.springtour.hotel.service;

import com.springtour.hotel.controller.RoomResponse;

import java.util.List;

public class RoomService {

    // RoomResponse 클래스는 Room Entity 객체를 클라이언트에게 응답하기 위한 DTO 입니다.
    // 객실 정보 조회 API 명세서의 Response 양식을 보시고 적절한 형태로 RoomResponse 클래스를 만들어주세요.
    // JSON message 의 viewType 속성은 미리 제공한 ViewType enum의 parameter 값을 사용해야 합니다.
    // Hint. javax.persistence.AttributeConverter 인터페이스와 @Convert 애너테이션을 사용하면 됩니다.
    public List<RoomResponse> getRoomsByHotelId(Long hotelId) {
        return null;
    }
}
