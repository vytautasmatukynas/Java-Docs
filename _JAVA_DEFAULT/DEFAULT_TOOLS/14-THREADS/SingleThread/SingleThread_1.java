

public class SingleThread_1 {

	public static void main(String[] args) {
		
		Worker2 w1 = new Worker2("Jonas");
		Worker2 w2 = new Worker2("Petras");
		Worker2 w3 = new Worker2("Antanas");
		
		w1.start();
		w2.start();
		w3.start();

	}

}


class Worker2 extends Thread {
	
	String name;
	
	public Worker2(String name) {
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
