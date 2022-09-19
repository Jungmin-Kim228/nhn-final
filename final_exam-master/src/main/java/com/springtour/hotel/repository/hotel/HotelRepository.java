package com.springtour.hotel.repository.hotel;

import com.springtour.hotel.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
