package org.coursera.tdd.handson.repository;

import org.coursera.tdd.handson.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<BookingModel, String> {
    Optional<BookingModel> findByBookingOwner(String name);
}
