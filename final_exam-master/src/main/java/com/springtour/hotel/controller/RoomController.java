package com.springtour.hotel.controller;

import com.springtour.hotel.domain.dto.RoomCreateRequest;
import com.springtour.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/hotel-api/hotels")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping("{hotel-id}/rooms")
    public String createRoom(@PathVariable("hotel-id") Long hotelId, @RequestBody RoomCreateRequest roomCreateRequest) {
        return roomService.createRoom(hotelId, roomCreateRequest);
    }

    @GetMapping("{hotel-id}/rooms")
    public List<RoomResponse> getRoomsByHotelId(@PathVariable("hotel-id") Long hotelId) {
        return roomService.getRoomsByHotelId(hotelId);
    }

}
