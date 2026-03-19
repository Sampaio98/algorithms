package implementation;

import java.util.ArrayList;
import java.util.List;

public class MemLeak {

    // static variables are never collected by GC
    private static final List<Object> staticList = new ArrayList<>();

    void main() throws InterruptedException {
        IO.println("Starting memory leak...");

        // JVM memory info
        long maxMemory = Runtime.getRuntime().maxMemory();
        IO.println("Memory heap: " + (maxMemory / 1024 / 1024) + "MB");

        int i = 0;
        try {
            while (true) {
                // adding 1GB every iteration
                staticList.add(new byte[1024 * 1024 * 1024]);
                IO.println("Added " + staticList.size() + " objects!");
                i++;

                // Memory used
                long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                IO.println("Memory used: " + (usedMemory / 1024 / 1024) + " MB");

                Thread.sleep(100);
            }
        } catch (OutOfMemoryError e) {
            System.err.println("\n\uD83D\uDCA5 OutOfMemoryError after " + i + " iterations!");
            System.err.println("List size: " + staticList.size());
        }
    }
}
