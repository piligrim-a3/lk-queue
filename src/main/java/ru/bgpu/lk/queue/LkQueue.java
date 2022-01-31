package ru.bgpu.lk.queue;

public class LkQueue<T> {

    private T[] array;
    private int front;
    private int current;

    public LkQueue(int size) {
        array = (T[]) (new Object[size+1]);
        front = 0;
        current = 0;
    }

    public void push(T value) {
        if(isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        array[current++] = value;
        if(current == array.length) {
            current = 0;
        }
    }

    public T pull() {
        if(current == front) {
            throw new IllegalStateException("Queue is empty");
        }
        T value = array[front++];
        array[front-1] = null;
        if(front == array.length) {
            front = 0;
        }
        return value;
    }

    public T peek() {
        if(current == front) {
            throw new IllegalStateException("Queue is empty");
        }
        return array[front];
    }

    public boolean isFull() {
        return current == front - 1 || (front == 0 && current == array.length - 1);
    }

    public boolean isEmpty() {
        return front == current;
    }

    public int maxSize() {
        return array.length-1;
    }

    public int size() {
        if(front <= current) {
            return current - front;
        } else {
            return array.length - (front - current);
        }
    }
}
