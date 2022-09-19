package com.springtour.hotel.domain;

import com.springtour.hotel.converter.ViewTypeConverter;
import com.springtour.hotel.domain.dto.RoomCreateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "Rooms")
@Entity
@Getter
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;

    @JoinColumn(name = "hotel_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Hotel hotel;

    @Column(unique = true)
    private String name;

    private Integer capacity;

    private Integer floor;

    @Column(name = "bathtub_flag")
    private boolean bathtubFlag;

    @Convert(converter = ViewTypeConverter.class)
    @Column(name = "view_type")
    private ViewType viewType;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Room(Hotel hotel, RoomCreateRequest roomCreateRequest) {
        this.hotel = hotel;
        this.name = roomCreateRequest.getName();
        this.capacity = roomCreateRequest.getCapacity();
        this.floor = roomCreateRequest.getFloor();
        this.bathtubFlag = roomCreateRequest.isHasBathtub();
        this.viewType = ViewType.fromParameter(roomCreateRequest.getViewType());
        this.createdAt = LocalDateTime.now();
    }

}
