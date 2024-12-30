package droksty.collections;

import java.util.Iterator;

/**
 * Generic double-ended queue.This collection
 * supports adding and removing items at both ends.
 * @author droksty
 * @param <E>   The type of elements in this {@link Deque}.
 */
public final class Deque<E> implements Iterable<E> {
    private int N;
    private Node left;
    private Node right;

    private class Node {
        E element;
        Node next;
        Node prev;
    }

    private class LeftToRightIterator implements Iterator<E> {
        Node current = left;

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
    }

    /**
     * Is this deque empty?
     * @return  True if this deque is empty, false otherwise.
     */
    public boolean isEmpty() { return N == 0; }

    /**
     * Number of elements in this deque.
     * @return  The number of elements in this deque.
     */
    public int size() { return N; }


    /**
     * Add an element to the left end.
     * @param element   The element to add.
     */
    public void pushLeft(E element) {
        Node newLeft = new Node();
        newLeft.element = element;
        newLeft.next = left;
        if (isEmpty()) right = newLeft;
        else left.prev = newLeft;
        left = newLeft;
        N++;
    }

    /**
     * Remove an element from the left end.
     * @return  The removed element.
     */
    public E popLeft() {
        if (isEmpty()) throw new UnsupportedOperationException("Deque is empty");
        E element = left.element;
        if (size() == 1) left = right = null;
        else {
            left = left.next;
            left.prev = null;
        }
        N--;
        return element;
    }

    /**
     * Add an element to the right end.
     * @param element   The element to add.
     */
    public void pushRight(E element) {
        Node newRight = new Node();
        newRight.element = element;
        newRight.prev = right;
        if (isEmpty()) left = newRight;
        else right.next = newRight;
        right = newRight;
        N++;
    }

    /**
     * Remove an element from the right end.
     * @return   The removed element.
     */
    public E popRight() {
        if (isEmpty()) throw new UnsupportedOperationException("Deque is empty");
        E element = right.element;
        if (size() == 1) right = left = null;
        else {
            right = right.prev;
            right.next = null;
        }
        N--;
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new LeftToRightIterator();
    }
}
