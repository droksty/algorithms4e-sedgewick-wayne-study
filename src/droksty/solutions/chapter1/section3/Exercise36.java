package droksty.solutions.chapter1.section3;

import droksty.collections.RandomQueue;  // ADT developed for this exercise

public class Exercise36 {
    public static void main(String[] args) {
        RandomQueue<Integer> randomQueue = new RandomQueue<>();
        randomQueue.enqueue(1);
        randomQueue.enqueue(2);
        randomQueue.enqueue(3);
        randomQueue.enqueue(4);
        randomQueue.enqueue(5);

        for (int i = 0; i < 50; i++) {
            for (Integer integer : randomQueue)
                System.out.print(integer);
            System.out.println();
        }
    }
}
