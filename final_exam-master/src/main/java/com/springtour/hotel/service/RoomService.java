package com.springtour.hotel.service;

import com.springtour.hotel.converter.TimeFormatter;
import com.springtour.hotel.domain.Book;
import com.springtour.hotel.domain.dto.RoomBookRequest;
import com.springtour.hotel.domain.dto.RoomResponse;
import com.springtour.hotel.domain.Hotel;
import com.springtour.hotel.domain.Room;
import com.springtour.hotel.domain.dto.RoomCreateRequest;
import com.springtour.hotel.exception.AlreadyBookedException;
import com.springtour.hotel.exception.AlreadyBookedThreeTimeException;
import com.springtour.hotel.exception.HotelNotFoundException;
import com.springtour.hotel.exception.RoomNotFoundException;
import com.springtour.hotel.exception.UserIdNotValidException;
import com.springtour.hotel.repository.book.BookRepository;
import com.springtour.hotel.repository.hotel.HotelRepository;
import com.springtour.hotel.repository.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.springtour.hotel.controller.UserAuthzValidator.isValid;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final BookRepository bookRepository;
    private final TimeFormatter timeFormatter;

    private static final Long THREE_TIME = 3L;

    // RoomResponse 클래스는 Room Entity 객체를 클라이언트에게 응답하기 위한 DTO 입니다.
    // 객실 정보 조회 API 명세서의 Response 양식을 보시고 적절한 형태로 RoomResponse 클래스를 만들어주세요.
    // JSON message 의 viewType 속성은 미리 제공한 ViewType enum의 parameter 값을 사용해야 합니다.
    // Hint. javax.persistence.AttributeConverter 인터페이스와 @Convert 애너테이션을 사용하면 됩니다.
    @Transactional(readOnly = true)
    public List<RoomResponse> getRoomsByHotelId(Long hotelId) {
        List<RoomResponse> roomResponseList = new ArrayList<>();
        List<Room> roomList = roomRepository.findRoomsByHotel_Id(hotelId);

        for (Room room : roomList) {
            RoomResponse roomResponse = new RoomResponse(room);
            roomResponse.changeTimeFormat(timeFormatter.convert(LocalDateTime.parse(roomResponse.getCreatedAt())));
            roomResponseList.add(roomResponse);
        }

        return roomResponseList;
    }

    @Transactional
    public String createRoom(Long hotelId, RoomCreateRequest roomCreateRequest) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(HotelNotFoundException::new);
        Room room = new Room(hotel, roomCreateRequest);

        roomRepository.save(room);

        return String.valueOf(room.getId());
    }

    @Transactional
    public String bookRoom(Long roomId, RoomBookRequest roomBookRequest) {
        validateBook(roomId, roomBookRequest);

        Room room = roomRepository.findById(roomId).orElseThrow(RoomNotFoundException::new);
        Book book = new Book(room, roomBookRequest);

        bookRepository.save(book);

        return room.getName() + " booked";
    }

    private void validateBook(Long roomId, RoomBookRequest roomBookRequest) {
        if (!isValid(roomBookRequest.getUserId())) {
            throw new UserIdNotValidException("예약이 불가능한 사용자입니다.");
        }
        if (bookRepository.isAlreadyBooked(roomId, roomBookRequest.getCheckIn(), roomBookRequest.getCheckOut())) {
            throw new AlreadyBookedException("이미 예약완료된 객실입니다.");
        }
        if (bookRepository.isAlreadyBookedThreeTimes(roomBookRequest.getUserId()) >= THREE_TIME) {
            throw new AlreadyBookedThreeTimeException();
        }
    }

}
