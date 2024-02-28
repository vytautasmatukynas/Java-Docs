package linux.ubuntu.postgres.panel.ui;

import java.util.Scanner;

public class Input {

	static Scanner scanner = new Scanner(System.in);

	public static void message(String msg) {
		System.out.println(msg);
	}

	public static void close() {
		scanner.close();
	}

	public static void consumeOutput() {
		scanner.nextLine();
	}

	public static String inputString(String msg) {
		message(msg);

		String inputData = scanner.nextLine();

		return inputData;
	}

	public static int inputInt(String msg) {
		message(msg);

		int inputData = scanner.nextInt();
		scanner.nextLine();

		return inputData;
	}

}
