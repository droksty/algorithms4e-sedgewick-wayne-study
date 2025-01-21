package droksty.solutions.chapter1.section3;

import droksty.collections.Stack;

public class Exercise42 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        var copy = new Stack<>(stack);
        stack.forEach(x -> System.out.print(x + " "));  // 3 2 1
        System.out.println();
        copy.forEach(x -> System.out.print(x + " "));   // 3 2 1
        System.out.println();
        System.out.println("stack size: " + stack.size());
        System.out.println("copy size: " + copy.size());

        System.out.println(copy.pop()); // 3
        System.out.println(copy.pop()); // 2
        copy.push(4);
        stack.push(4);

        stack.forEach(x -> System.out.print(x + " "));  // 4 3 2 1
        System.out.println();
        copy.forEach(x -> System.out.print(x + " "));   // 4 1
    }
}
