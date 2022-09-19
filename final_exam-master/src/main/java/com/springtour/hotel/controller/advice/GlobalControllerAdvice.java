package com.springtour.hotel.controller.advice;

import com.springtour.hotel.exception.AlreadyBookedException;
import com.springtour.hotel.exception.AlreadyBookedThreeTimeException;
import com.springtour.hotel.exception.Error;
import com.springtour.hotel.exception.HotelNotFoundException;
import com.springtour.hotel.exception.NotFoundException;
import com.springtour.hotel.exception.RoomNotFoundException;
import com.springtour.hotel.exception.UserIdNotValidException;
import com.springtour.hotel.exception.UserIdNullException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Order
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler({
            UserIdNullException.class, UserIdNotValidException.class,
    })
    public ResponseEntity<Error> userValidationExceptionHandle(UserIdNotValidException e) {
        log.error(e.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(new Error(e.getMessage()));
    }

    @ExceptionHandler({
            AlreadyBookedException.class, AlreadyBookedThreeTimeException.class
    })
    public ResponseEntity<Error> bookValidationExceptionHandle(AlreadyBookedException e) {
        log.error(e.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(new Error(e.getMessage()));
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<Error> validationExceptionHandle(MethodArgumentNotValidException e) {
        log.error(e.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(new Error("잘못된 요청입니다."));
    }

    @ExceptionHandler({
            HotelNotFoundException.class, RoomNotFoundException.class, NotFoundException.class
    })
    public ResponseEntity<Error> NotFoundExceptionHandle(NotFoundException e) {

        log.error(e.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(new Error(e.getMessage()));
    }

    @ExceptionHandler({
            RuntimeException.class
    })
    public ResponseEntity<Error> runtimeExceptionHandle(RuntimeException e) {
        log.error(e.toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(new Error("시스템에서 에러가 발생했습니다."));
    }

}
