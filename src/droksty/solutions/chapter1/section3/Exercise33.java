package droksty.solutions.chapter1.section3;

import droksty.collections.Deque;    // ADT developed for this exercise

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


        System.out.println("ArrayDeque:");      // Not implemented yet
    }
}
