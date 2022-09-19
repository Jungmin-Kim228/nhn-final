package com.springtour.hotel.domain;

import com.springtour.hotel.domain.dto.RoomBookRequest;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Table(name = "Books")
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @JoinColumn(name = "room_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "booked_at")
    private LocalDate bookedAt;

    @Column(name = "check_in")
    private LocalDate checkIn;

    @Column(name = "check_out")
    private LocalDate checkOut;

    public Book(Room room, RoomBookRequest roomBookRequest){
        this.room = room;
        this.userId = roomBookRequest.getUserId();
        this.bookedAt = LocalDate.now();
        this.checkIn = roomBookRequest.getCheckIn();
        this.checkOut = roomBookRequest.getCheckOut();
    }

}
