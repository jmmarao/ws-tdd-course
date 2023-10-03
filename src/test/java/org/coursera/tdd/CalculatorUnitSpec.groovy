package org.coursera.tdd

import spock.lang.Specification

class CalculatorUnitSpec extends Specification {
    private int number1
    private int number2

    def setup() {
        number1 = 10
        number2 = 20
    }

    def "Sum"() {
        given:
        number1
        number2

        when:
        def sum = number1 + number2

        then:
        sum == 30
    }
}
