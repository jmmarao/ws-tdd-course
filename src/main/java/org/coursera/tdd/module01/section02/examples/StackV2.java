package org.coursera.tdd.module01.section02.examples;

import java.util.ArrayList;
import java.util.List;

public class StackV2 {

    private List<Object> stack;

    private int size;

    public StackV2(int size) {
        stack = new ArrayList<>(size);
        this.size = size;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getSize() {
        return stack.size();
    }

    public void push(Object element) {
        if (size == getSize())
            throw new FullStackException("Can't push a full stack.");
        stack.add(element);
    }

    public Object getTop() {
        return stack.getFirst();
    }

    public void pop() {
        if (isEmpty())
            throw new EmptyStackException("Can't pop an empty stack.");
        stack.removeLast();
    }
}
