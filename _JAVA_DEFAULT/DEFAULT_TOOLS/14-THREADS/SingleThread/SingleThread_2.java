

public class SingleThread_2 {

	public static void main(String[] args) {
		
		Integer[] threadNum = {1, 2, 3, 4, 5};
		
		for (int name : threadNum) {
			Thread thread = new Thread(new Worker(name));
			thread.start();
		}

	}

}

class Worker implements Runnable {
	
	int name;
	
	public Worker(int name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for (int i = 0 ; i < 5 ; i++) {
			System.out.println(String.format("Woking thread-%s", name));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}


