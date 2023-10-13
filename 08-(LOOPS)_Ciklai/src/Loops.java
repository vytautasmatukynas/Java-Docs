
public class Loops {

	public static void main(String[] args) {

		advancedForLoops();
		inRange();
		doWhileLoop();
		whileLoop();

	}

	private static void advancedForLoops() {
		String zodis = "Labas";
		for (int i = 0; i < zodis.length(); i++) {
			System.out.println(zodis.charAt(i));
		}

		// loop thru String or something else
		for (String zodis1 = "Labas"; zodis1.length() < 0; zodis1.substring(0, zodis1.length() - 1)) {
			System.out.println(zodis1);
		}

		// loop thru array or some other set
		String[] zodziai = { "ooo", "aaa", "zzz" };
		for (String zodis1 : zodziai)
			System.out.println(zodis1);
	}

	private static void inRange() {
		// for loop. Print error prints in red.
		for (int i = 0; i < 5; i++) {
			System.err.println("Labas Vakaras");
		}

		// for loop. Print in one line
		for (int i = 0; i < 5; i++) {
			System.out.print("Labas Vakaras");
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
		// while
		int x = 0;

		while (x < 5) {
			System.out.println("Labas");
			x++;
		}
	}

}
