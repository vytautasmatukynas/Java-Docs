/**
 * This class provides an example of implementing a simple producer-consumer
 * pattern using Java's wait and notify mechanisms. It demonstrates how two
 * threads, one producing and the other consuming, can synchronize their
 * actions.
 */
public class WaitNotifyExample {
	
	private final Object lock = new Object(); // A lock object for synchronization
	private boolean isProduced = false; // A flag to track whether a product is available

	/**
	 * Simulate the producer's action.
	 * 
	 * @throws InterruptedException if an interruption occurs during execution
	 */
	public void produce() throws InterruptedException {
		synchronized (lock) {
			while (isProduced) {
				// Wait for the consumer to consume the product
				lock.wait();
			}

			System.out.println("Producing...");
			// Simulate some work
			Thread.sleep(1000);

			isProduced = true;
			// Notify the consumer that a product is ready
			lock.notify();
		}
	}

	/**
	 * Simulate the consumer's action.
	 * 
	 * @throws InterruptedException if an interruption occurs during execution
	 */
	public void consume() throws InterruptedException {
		synchronized (lock) {
			while (!isProduced) {
				// Wait for the producer to produce a product
				lock.wait();
			}

			System.out.println("Consuming...");
			// Simulate some work
			Thread.sleep(1000);

			isProduced = false;
			// Notify the producer that the product has been consumed
			lock.notify();
		}
	}
}
