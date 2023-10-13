import java.util.Scanner;

public class SwitchMethod {

	public static void main(String[] args) {

		switchSample();

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
				continue;
			}

		}

		scanner.close();
	}

}
