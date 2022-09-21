package com.springtour.hotel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springtour.hotel.controller.RoomController;
import com.springtour.hotel.converter.TimeFormatter;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@ActiveProfiles({ "real" })
@AutoConfigureMockMvc
public class convertRealTest {

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

    @Autowired
    TimeFormatter timeFormatter;

    @Test
    void testRealTimeFormat() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/v1/hotel-api/hotels/100/rooms")
                                                      .contentType(MediaType.APPLICATION_JSON))
                                     .andExpect(status().isOk())
                                     .andReturn();

        assertThat(mvcResult.getResponse().getContentAsString()).contains("2022-09-19 12:30:48");
    }

}
