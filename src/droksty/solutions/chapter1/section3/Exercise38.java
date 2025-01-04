package droksty.solutions.chapter1.section3;

import droksty.collections.GeneralizedArrayQueue;
import droksty.collections.GeneralizedQueue;

public class Exercise38 {
    public static void main(String[] args) {
        System.out.println("-".repeat(20));
        System.out.println("Test array impl");
        System.out.println("-".repeat(20));
        GeneralizedArrayQueue<Integer> integers = new GeneralizedArrayQueue<>();
        integers.insert(1);
        integers.insert(2);
        integers.insert(3);
        integers.insert(4);
        integers.delete(4);
        integers.forEach(integer -> System.out.print(integer + " "));   // 1 2 3
        System.out.println();
        integers.delete(1);
        integers.delete(2);
        integers.delete(1);
        integers.forEach(integer -> System.out.print(integer + " "));   //
        System.out.println("test");
        integers.insert(1);
        integers.insert(2);
        integers.insert(3);
        integers.insert(4);
        integers.delete(2);
        integers.delete(3);
        integers.forEach(integer -> System.out.print(integer + " "));   // 1 3
        System.out.println();

        System.out.println("-".repeat(20));
        System.out.println("Test linked list impl");
        System.out.println("-".repeat(20));
        GeneralizedQueue<String> strings = new GeneralizedQueue<>();
        strings.insert("1");
        strings.insert("2");
        strings.insert("3");
        strings.insert("4");
        strings.delete(4);
        strings.forEach(s -> System.out.print(s + " "));    // 1 2 3
        System.out.println();
        strings.delete(1);
        strings.delete(2);
        strings.delete(1);
        strings.forEach(s -> System.out.print(s + " "));    //
        System.out.println("test");
        strings.insert("1");
        strings.insert("2");
        strings.insert("3");
        strings.insert("4");
        System.out.println(strings.delete(2));
        System.out.println(strings.delete(3));
        strings.forEach(s -> System.out.print(s + " "));    // 1 3

    }
}
