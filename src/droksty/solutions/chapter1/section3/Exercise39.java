package droksty.solutions.chapter1.section3;

import droksty.collections.RingBuffer;  // ADT developed for this exercise

public class Exercise39 {
    public static void main(String[] args) {
        RingBuffer<Integer> buffer = new RingBuffer<>(4);
        System.out.println(buffer.poll());      // null
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        buffer.enqueue(4);
        buffer.enqueue(5);
        System.out.println(buffer.poll());      // 1;
        System.out.println(buffer.poll());      // 1;
        System.out.println(buffer.dequeue());   // 1;
        buffer.enqueue(5);
        System.out.println(buffer.dequeue());   // 2;
        System.out.println(buffer.dequeue());   // 3;
        System.out.println(buffer.dequeue());   // 4;
        System.out.println(buffer.dequeue());   // 5;
        System.out.println(buffer.dequeue());   // null
    }
}
