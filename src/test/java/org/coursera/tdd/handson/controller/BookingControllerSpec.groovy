package org.coursera.tdd.handson.controller

import org.coursera.tdd.handson.model.BookingModel
import spock.lang.Specification
import spock.lang.Subject

import java.time.LocalDate

class BookingControllerSpec extends Specification {

    @Subject
    private BookingController bookingController

    private BookingModel bookingModelMock

    def setup() {
        bookingController = new BookingController()

        LocalDate checkInMock = LocalDate.parse("2023-11-10")
        LocalDate checkOutMock = LocalDate.parse("2023-11-20")
        bookingModelMock = new BookingModel("1", "Jones", checkInMock, checkOutMock, 3)
    }

    def "Deve retornar a mensagem esperada ao realizar uma chamada para o endpoint de reservas"() {
        when: "O endpoint de buscar reservas for acionado"
        def bookingsMsg = bookingController.getBookings()

        then: "Deve retornar a mensagem esperada"
        bookingsMsg == "OK"
    }

    def "Deve retornar um objeto válido ao realizar uma chamada para o endpoint de cadastrar uma reserva"() {
        when: "O endpoint de cadastrar uma reserva"
        def bookingResult = bookingController.book(bookingModelMock)

        then: "Deve retornar a reserva realizada"
        bookingResult
    }
}
