package droksty.solutions.chapter1.section3;

import droksty.collections.CharacterSet;    // ADT developed for this exercise

import java.util.Scanner;

public class Exercise40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide a sequence of characters.");
        String userInput = scanner.nextLine();
        System.out.println("You entered: " + userInput);

        CharacterSet characterSet = new CharacterSet();
        char[] characters = userInput.toCharArray();
        characterSet.insertAll(characters);
        characterSet.printCharacters();
        System.out.println();
        characterSet.moveToFront('e');
        characterSet.printCharacters();
    }
}
