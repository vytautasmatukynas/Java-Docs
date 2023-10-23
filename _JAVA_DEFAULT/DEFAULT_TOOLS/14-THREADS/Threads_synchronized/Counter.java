/**
 * This class extends the Thread class and provides a synchronized method to increment a counter.
 * The synchronized method ensures that only one thread can access it at a time, preventing
 * concurrent access issues.
 */
public class Counter extends Thread {
	
    public int count = 0; // The shared counter

    /**
     * Synchronized method to increment the counter.
     * This method is synchronized to ensure that only one thread can access it at a time,
     * preventing race conditions.
     */
    public synchronized void increment() {
        count++;
        System.out.println("Current count: " + count);
    }
}

