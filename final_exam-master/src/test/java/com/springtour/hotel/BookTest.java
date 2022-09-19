package com.springtour.hotel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springtour.hotel.controller.RoomController;
import com.springtour.hotel.domain.Room;
import com.springtour.hotel.domain.dto.RoomBookRequest;
import com.springtour.hotel.repository.book.BookRepository;
import com.springtour.hotel.repository.hotel.HotelRepository;
import com.springtour.hotel.repository.room.RoomRepository;
import com.springtour.hotel.service.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class BookTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    RoomController roomcontroller;

    @Autowired
    RoomService roomService;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    BookRepository bookRepository;

    @Test
    void testBook() throws Exception {
        RoomBookRequest roomBookRequest = new RoomBookRequest();
        ReflectionTestUtils.setField(roomBookRequest, "userId", 100L);
        ReflectionTestUtils.setField(roomBookRequest, "checkIn", LocalDate.of(2022, 9, 10));
        ReflectionTestUtils.setField(roomBookRequest, "checkOut", LocalDate.of(2022, 9, 12));

        MvcResult mvcResult = mockMvc.perform(post("/v1/hotel-api/hotels/100/rooms/2")
                                                      .contentType(MediaType.APPLICATION_JSON)
                                                      .content(mapper.writeValueAsString(roomBookRequest)))
                                     .andExpect(status().isCreated())
                                     .andReturn();

        assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo("WestWing 1103 booked");
    }

}
