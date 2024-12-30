package droksty.solutions.chapter1.section3;

import droksty.collections.RandomBag;    // ADT developed for this exercise

import java.util.Scanner;

public class Exercise34 {
    public static void main(String[] args) {
        RandomBag<Integer> randomBag = new RandomBag<>();
        randomBag.add(1);
        randomBag.add(2);
        randomBag.add(3);
        randomBag.add(4);
        randomBag.add(5);
        randomBag.add(6);
        randomBag.add(7);
        randomBag.add(8);
        randomBag.add(9);
        randomBag.add(10);

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Press enter to randomly iterate over this bag..");
            String s = scanner.nextLine();
            if (s.isEmpty()) {
                for (Integer i : randomBag) {
                    System.out.print(i +" ");
                }
                System.out.println();
            } else {
                System.out.println("Thank you, bye.");
                break;
            }
        } while (scanner.hasNextLine());
    }
}
