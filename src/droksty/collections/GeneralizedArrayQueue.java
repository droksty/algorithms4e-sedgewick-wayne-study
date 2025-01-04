package droksty.collections;

import java.util.Iterator;

/**
 * A generic queue that supports deletion at any position.
 * @param <E>   The type of elements in this {@link GeneralizedArrayQueue}.
 */
@SuppressWarnings("unchecked")
public final class GeneralizedArrayQueue<E> implements Iterable<E> {
    private E[] arr;
    private int N;

    /**
     * Creates a new {@link GeneralizedArrayQueue} with initial capacity of 8.
     */
    public GeneralizedArrayQueue() {
        int DEFAULT_INITIAL_CAPACITY = 8;
        arr = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
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
     * @param element   The element to add.
     */
    public void insert(E element) {
        if (N == arr.length)
            resize(2 * arr.length);
        arr[N++] = element;
    }

    /**
     * Delete and return the kth least recently inserted element.
     * @param k Must be greater than 0 or not greater than the number of elements in the queue.
     * @return  The kth least recently inserted element.
     */
    public E delete(int k) {
        if (isEmpty()) throw new UnsupportedOperationException("Queue is empty.");
        if (k <= 0 || k > N) throw new IllegalArgumentException("Invalid argument value.");
        int index = k - 1;
        E element = arr[index];
        arr[index] = null;
        rotate(index);
        N--;
        if (N == arr.length / 4)
            resize(arr.length / 2);
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    // Helpers
    private void rotate(int startIndex) {
        for (int i = startIndex; i < N-1; i++)
            arr[i] = arr[i+1];
        arr[N-1] = null;
    }

    private void resize(int newCapacity) {
        E[] copy = (E[]) new Object[newCapacity];
        for (int i = 0; i < N; i++)
            copy[i] = arr[i];
        arr = copy;
    }

    private class QueueIterator implements Iterator<E> {
        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < N;
        }

        @Override
        public E next() {
            return arr[currentIndex++];
        }
    }
}
