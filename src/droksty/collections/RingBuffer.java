package droksty.collections;

/**
 * A FIFO data structure of fixed size.
 * @param <E>   The type of elements in this {@link RingBuffer}.
 */
public class RingBuffer<E> {
    private final int capacity;
    private final E[] ring;
    private int size;
    private int tail;
    private int head;

    /**
     * Creates a new {@link RingBuffer} with the specified fixed capacity.
     * @param capacity  Must be a positive integer.
     */
    @SuppressWarnings("unchecked")
    public RingBuffer(int capacity) {
        if (capacity < 1)
            throw new IllegalArgumentException("Capacity cannot be less than 1");
        this.capacity = capacity;
        this.ring = (E[]) new Object[capacity];
        tail = head = 0;
        size = 0;
    }

    /**
     *
     * @return  The capacity of this {@link RingBuffer}.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     *
     * @return  The number of items currently in this {@link RingBuffer}.
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @return  True, if this {@link RingBuffer} is empty. False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @return  True, if this {@link RingBuffer} is full. False otherwise.
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Adds an element to this {@link RingBuffer}.
     * Does nothing when this {@code RingBuffer} is full.
     * @param e The element to add.
     */
    public void enqueue(E e) {
        if (isFull()) {
            System.out.println("Buffer has reached maximum capacity. Enqueue operation not possible.");
        } else {
            ring[tail] = e;
            tail = (tail + 1) % capacity;
            size++;
        }
    }

    /**
     * Deletes and returns the element at the front of this {@link RingBuffer}.
     * @return  The deleted element, or null if this {@code RingBuffer} is empty.
     */
    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Buffer is empty.");
            return null;
        } else {
            E e = ring[head];
            ring[head] = null;
            head = (head + 1) % ring.length;
            size--;
            return e;
        }
    }

    /**
     * Returns the item at the front of this {@link RingBuffer} without removing it.
     * @return  The item at the front of this {@code RingBuffer}.
     */
    public E poll() {
        if (isEmpty()) {
            System.out.println("Buffer is empty.");
            return null;
        }
        return ring[head];
    }
}
