package com.springtour.hotel.domain;

import com.springtour.hotel.converter.ViewTypeConverter;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "Rooms")
@Entity
@Getter
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

    @Convert(converter = ViewTypeConverter.class)
    @Column(name = "view_type")
    private ViewType viewType;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
