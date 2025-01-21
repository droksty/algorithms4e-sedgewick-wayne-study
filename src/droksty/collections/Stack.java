package droksty.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Generic FIFO stack that supports the standard push and pop operations,
 * with additional methods developed as solutions to various exercises.
 * @param <E>   The type of elements in this {@link Stack}.
 */
public class Stack<E> implements Iterable<E> {
    private Node TOP;
    private int N;

    private class Node {
        private E e;
        private Node next;
    }

    /**
     * Instantiates a new, empty {@code Stack}
     */
    public Stack() {}

    /**
     * Creates an independent copy of s.
     * @param s The {@code Stack} to copy.
     */
    @SuppressWarnings("CopyConstructorMissesField")
    public Stack(Stack<E> s) {
        Stack<E> temp = new Stack<>();
        int size = s.size();

        // collect elements in proper order
        for (int i = 0; i < size; i++) {
            temp.push(s.pop());
        }

        for (int i = 0; i < size; i++) {
            E e = temp.pop();
            this.push(e);
            s.push(e);
        }
    }

    /**
     * Returns true if this {@code Stack} is empty.
     * @return  {@code true} if this {@code Stack} is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Returns the number of elements on this {@code Stack}.
     * @return  The number of elements on this {@code Stack}.
     */
    public int size() {
        return N;
    }

    /**
     * Adds the element on top of this {@code Stack}.
     * @param e The element to add.
     */
    public void push(E e) {
        Node oldTop = TOP;
        TOP = new Node();
        TOP.e = e;
        TOP.next = oldTop;
        N++;
    }

    /**
     * Removes and returns this {@code Stacks}'s most recently added element.
     * @return  This {@code Stacks}'s most recently added element.
     * @throws  NoSuchElementException if this {@code Stack} is empty.
     */
    public E pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty");
        E e = TOP.e;
        TOP = TOP.next;
        N--;
        return e;
    }

    /**
     * Returns an iterator that iterates over this stack in LIFO order.
     * @return  an iterator that iterates over this stack in LIFO order.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node curr = TOP;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public E next() {
                E e = curr.e;
                curr = curr.next;
                return e;
            }
        };
    }
}
