package org.coursera.tdd.module01.examples;

public class Stack {

    private Object[] elements;
    private int size;

    public Stack(int size) {
        elements = new Object[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void push(Object element) {
        if (size == elements.length)
            throw new FullStackException("Can't push a full stack.");
        this.elements[size] = element;
        size++;
    }

    public Object getTop() {
        return elements[size - 1];
    }

    public Object pop() {
        if (isEmpty())
            throw new EmptyStackException("Can't pop an empty stack.");
        Object top = getTop();
        size--;
        return top;
    }
}
