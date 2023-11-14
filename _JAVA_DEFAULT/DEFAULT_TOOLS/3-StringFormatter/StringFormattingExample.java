import java.util.Formatter;

public class StringFormattingExample {

	public static void main(String[] args) {
		/*
		 * %s is used to format a string. %c is used to format a char. %.1f is used to
		 * format a double with 1 decimal place. %.2f is used to format a float with 2
		 * decimal places. %d is used to format a integer. %,d is used to format a long.
		 */

		// Data types and their values
		char gender = 'M'; // Character representing gender
		double height = 175.5D; // Height in centimeters (Note the 'D' for double)
		float weight = 70.5f; // Weight in kilograms (Note the 'f' for float)
		long accountBalance = 1000000000L; // Account balance in dollars (Note the 'L' for long literal)
		int age = 30; // Age in years
		String name = "John"; // Name as a string

		// Using the Formatter class for formatting
		Formatter formatter = new Formatter();
		formatter.format("Name: %s, Age: %d, Gender: %c, Height: %.1f cm, Weight: %.2f kg, Balance: $%d", name, age,
				gender, height, weight, accountBalance);

		// Getting the formatted string
		String formattedString = formatter.toString();

		// Closing the formatter
		formatter.close();

		// Printing the formatted string
		System.out.println(formattedString);
	}
}
