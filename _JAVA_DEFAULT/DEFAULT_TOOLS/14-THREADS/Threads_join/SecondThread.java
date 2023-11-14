
public class SecondThread extends Thread {
	
    @Override
    public void run() {
        // This method will be executed when the thread is started
        System.out.println("Dirba thread du"); // Print a message
        System.out.println(System.currentTimeMillis()); // Print the current timestamp
    }
    
}
