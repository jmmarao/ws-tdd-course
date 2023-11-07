package org.coursera.tdd.module01.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class StackTest {

    private Stack stack;

    @BeforeEach
    public void setup() {
        stack = new Stack(10);
    }

    @Test
    @DisplayName("Should test if stack is empty")
    public void emptyStack() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());
    }

    @Test
    @DisplayName("Should test if stack has one element")
    public void oneElementStack() {
        stack.push("First");
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.getSize());
        assertEquals("First", stack.getTop());
    }

    @Test
    @DisplayName("Should test if stack push two elements and pop one correctly")
    public void twoElementsStack() {
        stack.push("First");
        stack.push("Second");
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.getSize());
        assertEquals("Second", stack.getTop());

        Object stackPopped = stack.pop();
        assertEquals(1, stack.getSize());
        assertEquals("First", stack.getTop());
        assertEquals("Second", stackPopped);
    }

    @Test
    @DisplayName("Should test if pop an empty stack")
    public void popAnEmptyStack() {
        assertThrows(EmptyStackException.class, () ->
                stack.pop()
        );
    }

    @Test
    @DisplayName("Should test if push a full stack")
    public void pushFullStack() {
        for (int i = 0; i < 10; i++) {
            stack.push("element" + i);
        }

        try {
            stack.push("Full-stack");
            fail();
        } catch (FullStackException exception) {
            assertEquals("Can't push a full stack.", exception.getMessage());
        }
    }
}