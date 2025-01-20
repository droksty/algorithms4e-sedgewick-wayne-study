package droksty.solutions.chapter1.section3;

import droksty.collections.Queue;

public class Exercise41 {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.forEach(x -> System.out.print(x + " "));
        System.out.println();

        Queue<Integer> copiedQ = new Queue<>(q);
        copiedQ.forEach(x -> System.out.print(x + " "));
        System.out.println();


        System.out.println("Test start");
        System.out.println(q.dequeue());                           // 1
        copiedQ.enqueue(5);
        q.forEach(x -> System.out.print(x + " "));          // 2 3 4
        System.out.println();
        copiedQ.forEach(x -> System.out.print(x + " "));    // 1 2 3 4 5
    }
}
