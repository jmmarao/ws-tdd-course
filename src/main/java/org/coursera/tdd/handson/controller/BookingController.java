package org.coursera.tdd.handson.controller;

import org.coursera.tdd.handson.model.BookingModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @GetMapping
    @ResponseBody
    public String getBookings() {
        return "OK";
    }

    @PostMapping
    public ResponseEntity<BookingModel> book(BookingModel bookingModel) {
        return ResponseEntity.status(HttpStatus.OK).body(bookingModel);
    }
}
