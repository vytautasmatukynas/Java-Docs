
public class Loops {

	public static void main(String[] args) {

		forEachLoop();
		inRange();
		doWhileLoop();
		whileLoop();

	}

	private static void forEachLoop() {
		for (String zodis1 = "Labas"; zodis1.length() < 0; zodis1.substring(0, zodis1.length() - 1)) {
			System.out.println(zodis1);
		}

		String[] zodziai = { "ooo", "aaa", "zzz" };
		for (String zodis1 : zodziai)
			System.out.println(zodis1);
	}

	private static void inRange() {
		for (int i = 0; i < 5; i++) {
			System.err.println("Labas Vakaras");
		}
	}

	private static void doWhileLoop() {
		// do - while. First does 'do' and then checks if 'y < 5'
		// 'do' always executes even if conditions in 'while' says false
		int y = 0;

		do {
			System.out.println("Labas Rytas");
			y++;
		} while (y < 5);
	}

	private static void whileLoop() {
		int x = 0;

		while (x < 5) {
			System.out.println("Labas");
			x++;
		}
		
	}

}
