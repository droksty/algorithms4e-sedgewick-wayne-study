package droksty.solutions.chapter1.section3;

import droksty.collections.Steque;   // ADT developed for this exercise

public class Exercise32 {
    public static void main(String[] args) {
        Steque<String> steque = new Steque<>();
        steque.push("t");
        steque.push("z");
        steque.push("z");
        steque.enqueue("o");
        steque.enqueue("p");
        System.out.println(steque.pop()); // z;
        System.out.println(steque.pop()); // z;
        for (String s : steque) {
            System.out.print(s);
        }
    }
}