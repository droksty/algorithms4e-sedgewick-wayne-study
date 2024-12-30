package droksty.collections;

import java.util.Iterator;
import java.util.Random;

/**
 * A {@link RandomQueue} is similar to a queue,
 * but the dequeue operation removes an element
 * from a random position, instead of from the first.
 * @author droksty
 * @param <E>   The type of elements in this {@link RandomQueue}.
 */
@SuppressWarnings("unchecked")
public final class RandomQueue<E> implements Iterable<E> {
    private static final int INITIAL_CAPACITY = 5;
    private E[] elements;
    private int N;

    /**
     * Creates a new {@link RandomQueue} with the default initial capacity.
     */
    public RandomQueue() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        N = 0;
    }

    /**
     * Creates a new {@link RandomQueue} with the specified initial capacity.
     * @param capacity  The initial capacity
     */
    public RandomQueue(int capacity) {
        elements = (E[]) new Object[capacity];
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
     * Add an element in this queue.
     * @param element   The element to add.
     */
    public void enqueue(E element) {
        if (N == elements.length)
            resize(2 * elements.length);
        elements[N++] = element;
    }

    /**
     * Remove a random element from the queue.
     * @return  The element to return.
     */
    public E dequeue() {
        if (isEmpty())
            throw new UnsupportedOperationException("Empty queue");
        Random random = new Random();
        int randomIndex = random.nextInt(N);
        E randomElement = elements[randomIndex];
        elements[randomIndex] = elements[N-1];
        elements[N-1] = null;
        N--;
        if (N == elements.length / 4)
            resize(elements.length / 2);
        return randomElement;
    }

    /**
     * Return a random element, but do not remove.
     * @return  A random element.
     */
    public E sample() {
        if (isEmpty()) throw new UnsupportedOperationException("Empty queue");
        Random random = new Random();
        return elements[random.nextInt(N)];
    }

    @Override
    public Iterator<E> iterator() {
        return new RandomIterator();
    }

    // Helper class. Can be improved with an int[] indicesArray?
    private class RandomIterator implements Iterator<E> {
        E[] randomElements;
        int current;

        private RandomIterator() {
            copy();
            shuffle();
            current = 0;
        }

        private void copy() {
            randomElements = (E[]) new Object[N];
            for (int i = 0; i < N; i++)
                randomElements[i] = elements[i];
        }

        private void shuffle() {
            Random random = new Random();
            for (int i = N-1; i > 0; i--) {
                int randomIndex = random.nextInt(N-1);
                E temp = randomElements[randomIndex];
                randomElements[randomIndex] = randomElements[i];
                randomElements[i] = temp;
            }
        }

        @Override
        public boolean hasNext() {
            return current < randomElements.length;
        }

        @Override
        public E next() {
            E e = randomElements[current];
            current++;
            return e;
        }
    }

    private void resize(int newCapacity) {
        E[] copyElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < N; i++)
            copyElements[i] = elements[i];
        elements = copyElements;
    }
}
