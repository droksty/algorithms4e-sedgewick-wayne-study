package droksty.collections;

import java.util.Iterator;

/**
 * A generic queue that supports deletion at any position.
 * @param <E>   The type of elements in this {@link GeneralizedArrayQueue}.
 */
public final class GeneralizedQueue<E> implements Iterable<E> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        E e;
        Node next;
    }

    /**
     * Create a new {@link GeneralizedArrayQueue}.
     */
    public GeneralizedQueue() {
        first = null;
        last = null;
        N = 0;
    }

    /**
     * Is this queue empty?
     * @return  True if this queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Add an element at the end of this queue.
     * @param e The element to add.
     */
    public void insert(E e) {
        Node node = new Node();
        node.e = e;
        if (isEmpty())  first = node;
        else            last.next = node;
        last = node;
        N++;
    }

    /**
     * Delete and return the kth least recently inserted element.
     * @param k Must be greater than 0 or not greater than the number of elements in the queue.
     * @return  The kth least recently inserted element.
     */
    public E delete(int k) {
        if (isEmpty())          throw new UnsupportedOperationException("Queue is empty.");
        if (k <= 0 || k > N)    throw new IllegalArgumentException("Invalid argument value.");

        E e;
        Node prev = null;
        Node current = first;
        for (int i = 1; i < k; i++) {
            prev = current;
            current = current.next;
        }

        if (k == 1)         first = first.next;
        if (prev != null)   prev.next = current.next;

        N--;
        if (isEmpty()) first = null;

        return current.e;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E e = current.e;
                current = current.next;
                return e;
            }
        };
    }
}
