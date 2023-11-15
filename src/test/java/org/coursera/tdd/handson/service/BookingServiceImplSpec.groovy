package org.coursera.tdd.handson.service

import org.coursera.tdd.handson.model.BookingModel
import org.coursera.tdd.handson.repository.BookingRepository
import org.coursera.tdd.handson.service.impl.BookingServiceImpl
import spock.lang.Specification
import spock.lang.Subject

import java.time.LocalDate

class BookingServiceImplSpec extends Specification {

    @Subject
    private BookingService bookingService

    private BookingRepository bookingRepository = Mock()

    private BookingModel bookingModelMock

    def setup() {
        bookingService = new BookingServiceImpl(bookingRepository)

        LocalDate checkInMock = LocalDate.parse("2023-11-10")
        LocalDate checkOutMock = LocalDate.parse("2023-11-20")
        bookingModelMock = new BookingModel("1", "Jones", checkInMock, checkOutMock, 3)
    }

    def "Deve validar a calculadora dos dias reservados"() {

        given: "Um hóspede que possui reservas no sistema"
        String name = "Jones"

        and: "Um retorno válido do repository ao buscar pelo nome do hóspede"
        1 * bookingRepository.findByBookingOwner(name) >> Optional.of(bookingModelMock)

        when: "A calculadora de dias for executada"
        int days = bookingService.daysCalculatorWithDatabase(name)

        then: "Deve retornar os dias reservados pelo hóspede"
        days == 10

    }
}
