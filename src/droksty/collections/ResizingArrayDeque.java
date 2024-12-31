package droksty.collections;

import java.util.Iterator;

/**
 * A double-ended queue that supports adding and removing elements at both ends.
 * @param <E>
 */
@SuppressWarnings("unchecked")
public final class ResizingArrayDeque<E> implements Iterable<E> {
    private final int INITIAL_CAPACITY = 4;
    private E[] arr = (E[]) new Object[INITIAL_CAPACITY];
    private int N = 0;

    /**
     * Is this deque empty?
     * @return  True if this deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Number of items in this deque.
     * @return  The number of items in this deque.
     */
    public int size() {
        return N;
    }

    /**
     * Add an element to the left end.
     * @param e The element to add.
     */
    public void pushLeft(E e) {
        if (N == arr.length)
            resize(2 * arr.length);
        shiftRight();
        arr[0] = e;
        N++;
    }

    /**
     * Add an element to the right end.
     * @param e The element to add.
     */
    public void pushRight(E e) {
        if (N == arr.length)
            resize(2 * arr.length);
        arr[N++] = e;
    }

    /**
     * Remove an element from the left end.
     * @return  The removed element.
     */
    public E popLeft() {
        if (isEmpty())  throw new UnsupportedOperationException("Deque is empty.");
        E e = arr[0];
        shiftLeft();
        N--;
        if (N == arr.length / 4)
            resize(arr.length / 2);
        return e;
    }

    /**
     * Remove an element from the right end.
     * @return  The removed element.
     */
    public E popRight() {
        if (isEmpty())  throw new UnsupportedOperationException("Deque is empty.");
        E e = arr[N-1];
        arr[N-1] = null;
        N--;
        if (N == arr.length / 4)
            resize(arr.length / 2);
        return e;
    }

    @Override
    public Iterator<E> iterator() {
        return new DequeIterator();
    }

    // Helpers
    private void shiftRight() {
        for (int i = N; i > 0; i--) {
            arr[i] = arr[i-1];
        }
    }

    private void shiftLeft() {
        for (int i = 0; i < N; i++) {
            arr[i] = arr[i+1];
        }
    }

    private void resize(int newCap) {
        E[] copy = (E[]) new Object[newCap];
        for (int i = 0; i < N; i++)
            copy[i] = arr[i];
        arr = copy;
    }

    private class DequeIterator implements Iterator<E> {
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
