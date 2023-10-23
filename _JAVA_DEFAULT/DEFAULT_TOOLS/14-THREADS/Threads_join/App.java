public class App {

    public static void main(String[] args) {
    	
        // Create and start the first custom thread (FirstThread)
        FirstThread thread = new FirstThread();
        thread.start();

        // Create and start the second custom thread (SecondThread)
        SecondThread thread2 = new SecondThread();
        thread2.start();

        try {
            // Wait for both threads to complete their execution
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Code execution continues after both threads have finished
        System.out.println("Baige darba"); // Print a message
        System.out.println(System.currentTimeMillis()); // Print the current timestamp
        
    }
}

