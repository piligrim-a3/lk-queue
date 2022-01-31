package ru.bgpu.lk.queue;

public class Main {

    public static void main(String[] args) {
        LkQueue<Integer> queue = new LkQueue<>(10);

        for(int i=0; i<10; i++) {
            queue.push(i);
        }

        for(int i=0; i<5; i++) {
            System.out.println(queue.pull());
        }
        System.out.println("size = "+queue.size());
        for(int i=0; i<5; i++) {
            System.out.println(queue.pull());
        }
        for(int i=0; i<10; i++) {
            queue.push(i);
        }
        System.out.println("size = "+queue.size());
        while (!queue.isEmpty()) {
            System.out.println(queue.pull());
        }
    }
}
