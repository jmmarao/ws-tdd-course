package org.coursera.tdd.handson.service.impl;

import lombok.RequiredArgsConstructor;
import org.coursera.tdd.handson.model.BookingModel;
import org.coursera.tdd.handson.repository.BookingRepository;
import org.coursera.tdd.handson.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public int daysCalculatorWithDatabase(String name) {

        Optional<BookingModel> bookingModelOptional = bookingRepository.findByBookingOwner(name);

        return Period.between(bookingModelOptional.get().getCheckIn(), bookingModelOptional.get().getCheckOut()).getDays();
    }

}
