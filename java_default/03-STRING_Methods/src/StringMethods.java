
public class StringMethods {

	public static void main(String[] args) {

		methodsWithString();
		splitStrings();
		mergeStrings();
		convertLineToString();
        stringFormat();
        
	}

	private static void stringFormat() {
        /*
         * %b is used to format a boolean.
         * %s is used to format a string.
         * %c is used to format a char.
         * %.1f is used to format a double with 1 decimal place.
         * %.2f is used to format a float with 2 decimal places.
         * %d is used to format a digits.
         */
        char gender = 'M';
        double height = 175.5456456464564D; // Note the 'D' to denote a double literal
        float weight = 70.5564645645f; // Note the 'f' to denote a float literal
        long accountBalance = 1000000000L; // Note the 'L' to denote a long literal
        int age = 30;
        String name = "John";

        // Formatting different data types
        String formattedString = String.format(
            "Name: %s, Age: %d, Gender: %c, Height: %.1f cm, Weight: %.2f kg, Balance: $%d | $%020d | $%20d | $%-20d |",
            name, age, gender, height, weight, accountBalance, accountBalance, accountBalance, accountBalance
        );
        
        System.out.println(formattedString);
	}

	private static void methodsWithString() {
		// STRING METHODS
		String sample_text = "hello world";

		// Substring method allows you to slice a String by specifying the starting
		// index and, optionally, the ending index

		System.out.println("Slice string from first char to fifth: " + sample_text.substring(0, 5)); // "hello"

		// Can add sliced string to variable or any other string method

		String sample_text_sliced = sample_text.substring(6);
		System.out.println("Some sliced text: " + sample_text_sliced); // "world"

		// Get only one char from string. Type is char

		char one_string_char = sample_text.charAt(1);
		System.out.println("Second string char: " + one_string_char); // 'e'

		// Get string length. Type is Integer

		int string_length = sample_text.length();
		System.out.println("string length: " + string_length); // 11

		// Get last item

		char last_char = sample_text.charAt(string_length - 1);
		System.out.println("Last char: " + last_char); // 'd'

		// Trim blank spaces from beginning and end of string

		String something_to_trim = "    TRIM!!    ";
		System.out.println("Cleaned data: " + something_to_trim.trim()); // "TRIM!!"

		// Replace data in string character "o" to "a"

		System.out.println("Change 'o' to 'O': " + sample_text.replace('o', 'O')); // "hellO wOrld"
		System.out.println("Change 'hello' to 'ooo': " + sample_text.replace("hello", "ooo")); // "ooo world"

		// Upper and Lower case

		String new_text_upper = sample_text.toUpperCase();
		System.out.println("UPPER: " + new_text_upper); // "HELLO WORLD"

		String new_text_lower = sample_text.toLowerCase();
		System.out.println("lower: " + new_text_lower); // "hello world"

		// Add string to end of string

		String result = sample_text.concat(" Have a nice day!");
		System.out.println(result); // "hello world Have a nice day!"

		// Compare strings and return True or False

		String otherString = "Hello, World!";
		boolean isEqual = sample_text.equals(otherString);
		System.out.println(isEqual); // false

		String otherString1 = "Hello World";
		boolean isEqual1 = sample_text.equals(otherString1);
		System.out.println(isEqual1); // false

		String otherString2 = "hello world";
		boolean isEqual2 = sample_text.equals(otherString2);
		System.out.println(isEqual2); // true

		String otherString3 = "Hello World";
		boolean isEqual3 = sample_text.equalsIgnoreCase(otherString3);
		System.out.println(isEqual3); // true

		// Check if string contains something

		boolean containsWorld = sample_text.contains("World");
		System.out.println(containsWorld); // true

		boolean containsWorld1 = sample_text.contains("world");
		System.out.println(containsWorld1); // false

		// String ends and starts with some data

		boolean startsWithHello = sample_text.startsWith("hello");
		System.out.println(startsWithHello); // true

		boolean endsWithWorld = sample_text.endsWith("world!");
		System.out.println(endsWithWorld); // false

		boolean startsWithFromIndex = sample_text.startsWith("he", 0);
		System.out.println(startsWithFromIndex); // true (starts from index 0)

		// Check if string is empty

		String emptyString = "";
		boolean isEmpty = emptyString.isEmpty();
		System.out.println(isEmpty); // isEmpty is true

		String someText = "aaa";
		boolean notEmpty = someText.isEmpty();
		System.out.println(notEmpty); // isEmpty is false
	}

	private static void splitStrings() {
		// Split string and get List of values
		String sentence = "this is a sample sentence.";
		String[] words = sentence.split(" "); // {"This", "is", "a", "sample", "sentence."}
		System.out.println("List of items: " + words + "\n"); // get array memory location - [Ljava.lang.String;@1ee0005
		System.out.println(words[0] + "\n"); // get first item in array - "this"

		// For loop array to print values
		for (String word : words) {
			System.out.println(word); // "This" "is" "a" "sample" "sentence."
		}
	}

	private static void mergeStrings() {
		// Add strings
		// Only + and += works on strings
		String text_1 = "pirmas ";
		String text_2 = "antras";
		System.out.println(text_1 + text_2);
		String text_3 = text_1 + text_2;
		System.out.println(text_3);
		text_1 += text_2;
		System.out.println(text_1);
	}

	private static void convertLineToString() {
		// Change to string line
		System.out.println(String.valueOf(5 + 6)); // "11"
		System.out.println("" + (5 + 6)); // "11"
		System.out.println("" + 5 + 6); // "57"
	}

}
