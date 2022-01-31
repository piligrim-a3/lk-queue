package ru.bgpu.lk.queue;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        LkPriorityQueue<Integer> queue = new LkPriorityQueue<>(Integer.class,10);
        Random random = new Random();
        int outCount = 5;
        while (!queue.isFull()) {
            int value = random.nextInt(100);
            System.out.println("push: "+value);
            queue.push(value);
            if(random.nextBoolean() && outCount > 0) {
                outCount--;
                System.out.println("pull: "+queue.pull());
            }
        }
        System.out.println(queue);
    }
}
