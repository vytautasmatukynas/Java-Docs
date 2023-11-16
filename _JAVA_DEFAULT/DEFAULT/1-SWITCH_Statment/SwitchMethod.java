import java.util.Scanner;

public class SwitchMethod {

	public static void main(String[] args) {

		switchSample();
		switchSampleWithLambda();

	}

	private static void switchSample() {
		int savDiena;

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("Savaites diena: ");
			String inputDienaString = scanner.nextLine();

			if (inputDienaString.equalsIgnoreCase("quit")) {
				System.out.println("Exiting");
				break; // Exit the loop
			}

			try {
				savDiena = Integer.parseInt(inputDienaString);
			} catch (NumberFormatException e) {
				System.out.println("prasau irasyti skaiciu");
				continue;
			}

			switch (savDiena) {
				case 1:
					System.out.println("pirmadienis");
					continue;
				case 2:
					System.out.println("antradienis");
					continue;
				case 3:
					System.out.println("treciadienis");
					continue;
				case 4:
					System.out.println("ketviratdienis");
					continue;
				case 5:
					System.out.println("penktadienis");
					continue;
				case 6:
					System.out.println("sestadienis");
					continue;
				case 7:
					System.out.println("sekmadienis");
					continue;
				default:
					System.out.println("Irasyk tinkama diena nuo 1 iki 7");
			}

		}

		scanner.close();
	}

	private static void switchSampleWithLambda() {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();

		String dayOfWeek = switch (input) {
			case 1 -> "pirmadienis";
			case 2 -> "antradienis";
			case 3 -> "treciadienis";
			case 4 -> "ketvirtadienis";
			case 5 -> "penktadienis";
			case 6 -> "sestadienis";
			case 7 -> "sekmadienis";
			default -> "Įrašykite tinkamą dieną nuo 1 iki 7";
		};

		System.out.println(dayOfWeek);
	}

}
