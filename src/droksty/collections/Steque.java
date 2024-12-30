package droksty.collections;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Generic collection that supports push, pop and enqueue operations.
 * @author droksty
 * @param <E>   The type of elements in this {@link Steque}.
 */
public final class Steque<E> implements Iterable<E> {
    private Node HEAD;
    private Node TAIL;
    private int N;

    private class Node {
        E element;
        Node next;
    }

    private class StequeIterator implements Iterator<E> {
        private Node current = HEAD;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E element = current.element;
            current = current.next;
            return element;
        }

        @Override
        public void remove() {
            throw new ConcurrentModificationException();
        }
    }

    /**
     * Is this steque empty?
     * @return  True if this steque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Number of elements in this steque.
     * @return  The number of elements in this steque.
     */
    public int size() {
        return N;
    }

    /**
     * Add on top of this steque.
     * @param element The element to add.
     */
    public void push(E element) {
        Node newHead = new Node();
        newHead.element = element;
        newHead.next = HEAD;
        HEAD = newHead;
        if (isEmpty()) TAIL = HEAD;
        N++;
    }

    /**
     * Remove the element on top of this steque.
     * @return  The removed element.
     */
    public E pop() {
        if (isEmpty()) throw new UnsupportedOperationException("Steque is empty");
        E element = HEAD.element;
        HEAD = HEAD.next;
        N--;
        if (isEmpty()) TAIL = null; // ?
        return element;
    }

    /**
     * Add at the bottom of this steque.
     * @param element The element to add.
     */
    public void enqueue(E element) {
        Node newTail = new Node();
        newTail.element = element;

        if (isEmpty()) {
            HEAD = TAIL = newTail;
        } else {
            TAIL.next = newTail;
            TAIL = newTail;
        }

        N++;
    }

    @Override
    public Iterator<E> iterator() {
        return new StequeIterator();
    }
}
