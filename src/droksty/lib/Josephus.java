package droksty.lib;

import droksty.collections.Queue;

/**
 * Solves the Josephus problem.
 * Requires two command line arguments:
 * M for the total number of people and N for the interval.
 */
public final class Josephus {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);

        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < N; i++)
            queue.enqueue(i);

        int count = 0;
        while (queue.size() != 1) {
            Integer next = queue.dequeue();
            count++;
            if (count == M) {
                System.out.print(next + " ");
                count = 0;
            }
            else {
                queue.enqueue(next);
            }
        }

        System.out.println(queue.dequeue());
    }
}
