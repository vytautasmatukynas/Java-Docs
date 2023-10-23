/**
 * This class demonstrates a simple example of multi-threading in Java, where
 * two threads concurrently increment a shared counter using the Counter class.
 */
public class App {

	public static void main(String[] args) {
		// Create a shared instance of the Counter class
		Counter counter = new Counter();

		// Create the first thread to increment the counter
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				// Increment the counter using the Counter instance
				counter.increment();
			}
		});

		// Create the second thread to increment the counter
		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				// Increment the counter using the Counter instance
				counter.increment();
			}
		});

		// Start both threads
		thread1.start();
		thread2.start();

		// Wait for both threads to finish their work
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// After both threads have completed, print the final count
		System.out.println("Final count: " + counter.count);
	}
}
