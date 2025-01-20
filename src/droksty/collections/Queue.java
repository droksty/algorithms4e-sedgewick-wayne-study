package droksty.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A generic FIFO queue that supports the typical enqueue and dequeue operations,
 * with additional methods developed as solutions to various exercises.
 * @param <E>   The type of elements in this {@link Queue}.
 */
public class Queue<E> implements Iterable<E> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        private E e;
        private Node next;
    }

    /**
     * Creates an empty {@link Queue}.
     */
    public Queue() {}

    /**
     * Creates an independent copy of q.
     * @param q The {@code Queue} to copy.
     */
    public Queue(Queue<E> q) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            E e = q.dequeue();
            this.enqueue(e);
            q.enqueue(e);
        }
    }

    /**
     * Returns true if this {@code Queue} is empty.
     * @return  {@code true} if this {@code Queue} is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Returns the number of items in this {@code Queue}.
     * @return  The number of items in this {@code Queue}.
     */
    public int size() {
        return N;
    }

    /**
     * Adds an element to this {@code Queue}
     * @param e The element to add.
     */
    public void enqueue(E e) {
        Node oldLast = last;
        last = new Node();
        last.e = e;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        N++;
    }

    /**
     * Removes and returns this {@code Queue}'s least recently added element.
     * @return  This {@code Queue}'s least recently added element.
     * @throws NoSuchElementException if this {@code Queue} is empty.
     */
    public E dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        E e = first.e;
        first = first.next;
        N--;
        if (isEmpty())
            last = null;
        return e;
    }

    /**
     * Returns an iterator that iterates over this {@code Queue} in FIFO order.
     * @return  An iterator that iterates over this {@code Queue} in FIFO order.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node curr = first;

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
