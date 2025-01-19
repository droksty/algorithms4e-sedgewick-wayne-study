package droksty.solutions.chapter1.section3;

import droksty.collections.Deque;               // ADT developed for this exercise
import droksty.collections.ResizingArrayDeque;  // ADT developed for this exercise

public class Exercise33 {
    public static void main(String[] args) {
        System.out.println("Deque:");
        Deque<String> deque = new Deque<>();
        deque.pushRight("a");
        System.out.println(deque.popLeft());    // a
        deque.pushLeft("b");
        deque.pushLeft("c");
        deque.pushRight("a");
        deque.forEach(System.out::print);       // cba
        System.out.println();
        System.out.println();

        System.out.println("ArrayDeque:");
        ResizingArrayDeque<Integer> integers = new ResizingArrayDeque<>();
        integers.pushLeft(1);
        integers.pushLeft(2);
        integers.pushLeft(3);
        integers.pushLeft(4);
        for (Integer integer : integers)
            System.out.printf("%2d ", integer);    // 4 3 2 1
        System.out.println();
        integers.pushRight(0);
        integers.pushRight(-1);
        integers.pushRight(-2);
        integers.pushRight(-3);
        integers.pushRight(-4);
        integers.pushRight(-5);
        integers.pushLeft(5);
        for (Integer integer : integers)
            System.out.printf("%2d ", integer);     // 5 4 3 2 1 0 -1 -2 -3 -4 -5
        System.out.println();
        System.out.println(integers.popLeft());
        System.out.println(integers.popLeft());
        System.out.println(integers.popLeft());
        integers.pushLeft(3);
        for (Integer integer : integers)
            System.out.printf("%2d ", integer);     // 3 2 1 0 -1 -2 -3 -4 -5
        System.out.println();
        System.out.println(integers.popRight());
        System.out.println(integers.popRight());
        System.out.println(integers.popRight());
        integers.pushRight(-3);
        for (Integer integer : integers)
            System.out.printf("%2d ", integer);     // 3 2 1 0 -1 -2 -3
    }
}
