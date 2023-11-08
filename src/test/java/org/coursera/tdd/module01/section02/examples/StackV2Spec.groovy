package org.coursera.tdd.module01.section02.examples

import spock.lang.Specification

class StackV2Spec extends Specification {

    private StackV2 stackV2

    def setup() {
        stackV2 = new StackV2(10)
    }

    def "Should check if the stack is empty"() {
        when: "The function getSize is called"
        int numberOfElements = stackV2.getSize()

        then: "It should return and empty stack"
        stackV2.isEmpty()

        and: "It should return zero elements"
        numberOfElements == 0
    }

    def "Should check if the stack has one element"() {
        given: "An element is added to the stack using the function push"
        stackV2.push(3)

        when: "The function getSize is called"
        int numberOfElements = stackV2.getSize()

        then: "It should not return and empty stack"
        !stackV2.isEmpty()

        and: "It should return one element"
        numberOfElements == 1

        and: "The function getTop should return the top element in stack"
        stackV2.getTop() == 3
    }

    def "Should check if the stack push three elements and pop one correctly"() {
        given: "Two elements is added to the stack using the function push"
        stackV2.push(3)
        stackV2.push(5)
        stackV2.push(7)

        when: "The function pop is called"
        stackV2.pop()

        and: "The function getSize is called"
        int numberOfElements = stackV2.getSize()

        then: "It should not return and empty stack"
        !stackV2.isEmpty()

        and: "It should return one element"
        numberOfElements == 2

        and: "The function getTop should return the top element in stack"
        stackV2.getTop() == 3
    }

    def "Should throw an empty stack exception if pop an empty stack"() {
        when: "The function pop is executed in a empty stack"
        stackV2.pop()

        then: "An empty stack exception thrown"
        thrown(EmptyStackException)
    }

    def "Should throw a full stack exception if push a full stack"() {
        when: "The function push 11 elements"
        for (int i = 0; i < 11; i++) {
            stackV2.push("element" + i)
        }

        then: "A full stack exception thrown"
        thrown(FullStackException)
    }
}
