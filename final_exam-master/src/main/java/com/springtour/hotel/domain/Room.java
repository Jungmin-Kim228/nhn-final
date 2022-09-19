package com.springtour.hotel.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "Rooms")
@Entity
public class Room {

    @Id
    @Column(name = "room_id")
    private Long id;

    @JoinColumn(name = "hotel_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Hotel hotel;

    private String name;

    private Integer capacity;

    private Integer floor;

    @Column(name = "bathtub_flag")
    private boolean bathtubFlag;

    @Column(name = "view_type")
    private ViewType viewType;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
