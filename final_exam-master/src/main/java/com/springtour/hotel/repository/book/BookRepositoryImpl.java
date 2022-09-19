package com.springtour.hotel.repository.book;

import com.springtour.hotel.domain.Book;
import com.springtour.hotel.domain.QBook;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.time.LocalDate;

public class BookRepositoryImpl extends QuerydslRepositorySupport implements BookRepositoryCustom {

    public BookRepositoryImpl() {
        super(Book.class);
    }

    @Override
    public boolean isAlreadyBooked(Long roomId, LocalDate checkIn, LocalDate checkOut) {
        QBook book = QBook.book;

        Long count = from(book)
                .where(book.room.id.eq(roomId))
                .where(book.checkIn.between(checkIn, checkOut).or(book.checkOut.between(checkIn, checkOut)))
                .select(book)
                .fetchCount();

        return count > 0;
    }

    @Override
    public Long isAlreadyBookedThreeTimes(Long userId) {
        QBook book = QBook.book;

        return from(book)
                .where(book.userId.eq(userId))
                .where(book.bookedAt.eq(LocalDate.now()))
                .fetchCount();
    }

}
