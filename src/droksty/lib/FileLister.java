package droksty.lib;

import droksty.collections.Queue;

import java.io.File;

/**
 * Takes the name of a folder as a command-line argument and
 * prints out all the files contained in that folder,
 * with the contents of each folder recursively listed (indented)
 * under that folder's name.
 *
 * @author droksty
 */
public final class FileLister {
    private FileLister() {}

    private static void enqueue(Queue<String> queue, File file, int indentation) {
        StringBuilder sb = new StringBuilder();
        sb.append("  ".repeat(Math.max(0, indentation)));
        queue.enqueue(sb + file.getName());
    }

    private static void buildQueue(Queue<String> queue, File folder, int indentation) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                enqueue(queue, file, indentation);
                buildQueue(queue, file, indentation + 1);
            } else {
                enqueue(queue,file, indentation);
            }
        }
    }

    public static void main(String[] args) {
        /* -- init start -- */
        File folder = new File(args[0]);
        if (!folder.exists())
            throw new IllegalArgumentException("Folder does not exist, enter a valid pathname.");
        int indentation = 0;
        Queue<String> queue = new Queue<>();
        /* -- init end -- */

        System.out.println(folder.getName());
        buildQueue(queue, folder, indentation + 1);
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
