package org.coursera.tdd.module01.section02.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class StackV1Test {

    private StackV1 stackV1;

    @BeforeEach
    public void setup() {
        stackV1 = new StackV1(10);
    }

    @Test
    @DisplayName("Should test if stack is empty")
    public void emptyStack() {
        assertTrue(stackV1.isEmpty());
        assertEquals(0, stackV1.getSize());
    }

    @Test
    @DisplayName("Should test if stack has one element")
    public void oneElementStack() {
        stackV1.push("First");
        assertFalse(stackV1.isEmpty());
        assertEquals(1, stackV1.getSize());
        assertEquals("First", stackV1.getTop());
    }

    @Test
    @DisplayName("Should test if stack push two elements and pop one correctly")
    public void twoElementsStack() {
        stackV1.push("First");
        stackV1.push("Second");
        assertFalse(stackV1.isEmpty());
        assertEquals(2, stackV1.getSize());
        assertEquals("Second", stackV1.getTop());

        Object stackPopped = stackV1.pop();
        assertEquals(1, stackV1.getSize());
        assertEquals("First", stackV1.getTop());
        assertEquals("Second", stackPopped);
    }

    @Test
    @DisplayName("Should test if pop an empty stack")
    public void popAnEmptyStack() {
        assertThrows(EmptyStackException.class, () ->
                stackV1.pop()
        );
    }

    @Test
    @DisplayName("Should test if push a full stack")
    public void pushFullStack() {
        for (int i = 0; i < 10; i++) {
            stackV1.push("element" + i);
        }

        try {
            stackV1.push("Full-stack");
            fail();
        } catch (FullStackException exception) {
            assertEquals("Can't push a full stack.", exception.getMessage());
        }
    }
}