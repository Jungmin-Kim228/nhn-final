package com.springtour.hotel.controller;

import com.springtour.hotel.domain.dto.RoomCreateRequest;
import com.springtour.hotel.domain.dto.RoomResponse;
import com.springtour.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/hotel-api/hotels")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping("{hotel-id}/rooms")
    public ResponseEntity<String> createRoom(@PathVariable("hotel-id") Long hotelId,
                                             @Valid @RequestBody RoomCreateRequest roomCreateRequest) {

        String hotelIdResponse = roomService.createRoom(hotelId, roomCreateRequest);

        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(hotelIdResponse);
    }

    @GetMapping("{hotel-id}/rooms")
    public ResponseEntity<List<RoomResponse>> getRoomsByHotelId(@PathVariable("hotel-id") Long hotelId) {
        List<RoomResponse> roomResponseList = roomService.getRoomsByHotelId(hotelId);

        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(roomResponseList);
    }

}
