package com.springtour.hotel.repository.book;

import com.springtour.hotel.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {



}
