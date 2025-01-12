package droksty.collections;

/**
 * A collection of characters with no duplicates.
 *
 * @author droksty
 */
public final class CharacterSet {
    private Node front;
    private int N;

    private class Node {
        private char character;
        private Node next;
    }

    private void insertFront(char character) {
        Node node = new Node();
        node.character = character;
        if (N != 0)
            node.next = front;
        front = node;
        N++;
    }

    /**
     * Inserts a previously unseen character to the front of this {@link CharacterSet}.
     * If the character already exists in the collection, it is moved to the front.
     * @param character The character to insert or move (in case of duplicate).
     */
    public void moveToFront(char character) {
        if (front == null)                      // initialize list
            insertFront(character);
        else if (front.character == character)  // no action required
            ;
        else {                                  // insert or move to front
            Node current = front;
            Node next = current.next;

            while (next != null) {
                if (next.character == character) {
                    current.next = next.next;
                    next.next = front;
                    front = next;
                    return;
                }
                current = next;
                next = current.next;
            }

            insertFront(character);
        }
    }

    /**
     * Inserts the characters of the provided sequence by applying the move-to-front strategy.
     * @param sequence  The sequence of characters.
     */
    public void insertAll(char[] sequence) {
        for (char c : sequence) {
            moveToFront(c);
        }
    }

    /**
     * Print all the characters of this {@link CharacterSet} in reverse order.
     */
    public void printCharacters() {
        Node curr = front;
        while (curr != null) {
            System.out.print(curr.character + " ");
            curr = curr.next;
        }
    }
}
