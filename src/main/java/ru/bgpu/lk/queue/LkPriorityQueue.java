package ru.bgpu.lk.queue;

import java.lang.reflect.Array;

public class LkPriorityQueue<T extends Comparable<T>> {

    private T[] array;
    private int current;

    public LkPriorityQueue(Class<T> clazz, int size) {
        array = (T[]) Array.newInstance(clazz, size);
        current = 0;
    }

    public void push(T value) {
        if(isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        int insertIndex = current++;
        for(;insertIndex > 0 && array[insertIndex-1].compareTo(value) < 0;insertIndex--) {
            array[insertIndex] = array[insertIndex-1];
        }
        array[insertIndex] = value;
    }

    public T pull() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return array[--current];
    }

    public T peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return array[current-1];
    }

    public boolean isFull() {
        return current == array.length;
    }

    public boolean isEmpty() {
        return current == 0;
    }

    @Override
    public String toString() {
        String out = "[";
        for(int i = current-1; i > 0; i--) {
            out += array[i] + (i == 1 ? "" : ",");
        }
        return out+"]";
    }
}
