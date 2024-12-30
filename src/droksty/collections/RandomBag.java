package droksty.collections;

import java.util.Iterator;
import java.util.Random;

/**
 * A generic collection that supports adding elements and randomly iterating over them.
 * @param <E>   The type of elements in this {@link RandomBag}
 */
@SuppressWarnings("unchecked")
public final class RandomBag<E> implements Iterable<E> {
    private E[] elements;
    private int N;

    /**
     * Create a new empty {@link RandomBag} with default initial capacity.
     */
    public RandomBag() {
        int DEFAULT_INITIAL_CAPACITY = 10;
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        N = 0;
    }

    /**
     * Is this bag empty?
     * @return  True if the bag is empty, false otherwise.
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Number of elements in this bag.
     * @return  The number of elements in this bag.
     */
    public int size() {
        return N;
    }

    /**
     * Add an element.
     * @param element   The element to add.
     */
    public void add(E element) {
        if (N == elements.length)
            resize();
        elements[N++] = element;
    }

    @Override
    public Iterator<E> iterator() {
        return new RandomBagIterator();
    }

    // Helpers
    private void resize() {
        E[] tmp = (E[]) new Object[elements.length * 2];
        for (int i = 0; i < N; i++)
            tmp[i] = elements[i];
        elements = tmp;
    }

    private class RandomBagIterator implements Iterator<E> {
        E[] copiedElements;
        int current = 0;

        RandomBagIterator() {
            copiedElements = (E[]) new Object[N];
            copyElements();
            shuffleCopiedElements();
        }

        private void copyElements() {
            for (int i = 0; i < N; i++)
                copiedElements[i] = elements[i];
        }

        private void shuffleCopiedElements() {
            Random random = new Random();
            for (int i = copiedElements.length - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);
                E temp = copiedElements[i];
                copiedElements[i] = copiedElements[j];
                copiedElements[j]=temp;
            }
        }

        @Override
        public boolean hasNext() {
            return current < copiedElements.length;
        }

        @Override
        public E next() {
            return copiedElements[current++];
        }
    }
}
