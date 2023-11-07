
/**
 * This class demonstrates the usage of the WaitNotifyExample class to implement
 * a producer-consumer pattern using two separate threads for producing and
 * consuming, showing how they synchronize their actions.
 */
public class App {

	public static void main(String[] args) {

		// Create an instance of the WaitNotifyExample class.
		WaitNotifyExample example = new WaitNotifyExample();

		// Create a producer thread.
		Thread producerThread = new Thread(() -> {
			try {
				while (true) {
					// Call the produce() method of the example instance to simulate the producer's
					// action.
					example.produce();
				}
			} catch (InterruptedException e) {
				// Handle any InterruptedException that may occur by interrupting the thread.
				Thread.currentThread().interrupt();
			}
		});

		// Create a consumer thread.
		Thread consumerThread = new Thread(() -> {
			try {
				while (true) {
					// Call the consume() method of the example instance to simulate the consumer's
					// action.
					example.consume();
				}
			} catch (InterruptedException e) {
				// Handle any InterruptedException that may occur by interrupting the thread.
				Thread.currentThread().interrupt();
			}
		});

		// Start the producer thread, allowing it to execute the code defined in the
		// lambda expression.
		producerThread.start();

		// Start the consumer thread, allowing it to execute the code defined in the
		// lambda expression.
		consumerThread.start();

	}
}
