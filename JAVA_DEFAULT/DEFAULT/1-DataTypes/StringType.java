
public class StringType {
	
	public static void stringFormat() {
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
	
	public static void convertToString() {
		System.out.println(String.valueOf(5 + 6)); // "11"
		System.out.println("" + (5 + 6)); // "11"
		System.out.println("" + 5 + 6); // "57"
	}

	public static void mergeStrings() {
		// Only + and += works on strings
		String text_1 = "pirmas ";
		String text_2 = "antras";
		System.out.println(text_1 + text_2);
		
		String text_3 = text_1 + text_2;
		System.out.println(text_3);
		
		text_1 += text_2;
		System.out.println(text_1);
	}

	public static void splitMethods () {
		// Split String to String array with String elements
		splitStrings();
		
		// Split String to Char array with Char elements
		splitToCharArray(); 
		
		// Split String to Byte array with Byte elements
		splitToBytesArray();
	}

	private static void splitToBytesArray() {
		String sample_text = "hello world";
		byte[] toBytesArray = sample_text.getBytes();
		
		for (byte bytes : toBytesArray)
			System.out.println(bytes);
	}
	
	private static void splitToCharArray() {
		String sentence = "this is a sample sentence.";
		char[] toCharArray = sentence.toCharArray();
		for (char chars : toCharArray)
			System.out.println(chars);
	}

	private static void splitStrings() {
		String sentence = "this is a sample sentence.";
		String[] words = sentence.split(" "); // {"This", "is", "a", "sample", "sentence."}
		System.out.println("List of items: " + words + "\n"); // get array memory location - [Ljava.lang.String;@1ee0005
		System.out.println(words[0] + "\n"); // get first item in array - "this"

		for (String word : words)
			System.out.println(word); // "This" "is" "a" "sample" "sentence."
	}
	
	public static void methods() {
		String sample_text = "hello world";

		// Substring method allows you to slice a String by specifying the starting
		// index and optionally the ending index
		substring(sample_text);

		// Get one Char from string by using index. Type is Char
		charAt(sample_text);

		// Get last Char
		lastCharAt(sample_text);

		// Get string length. Type is Integer
		length(sample_text);

		// Trim blank spaces from beginning and end of String
		trim();

		// Replace existing String part with new String
		replace(sample_text);

		// Upper and Lower case
		toUpper(sample_text);
		toLower(sample_text);

		// Add string to end of string
		concat(sample_text);

		// Compare strings and return True or False
		equals(sample_text);

		// Check if string contains something
		contains(sample_text);

		// String ends and starts with some data
		startsWith(sample_text);
		endsWith(sample_text);

		// Check if string is empty
		isEmpty();
		
		// Check if string is empty or contains 1 blank space
		isBlank(sample_text);
	}

    private static void isBlank(String sample_text) {
        System.out.println("Is Blank: " + sample_text.isBlank());
    }

    private static void isEmpty() {
        String emptyString = "";
        boolean isEmpty = emptyString.isEmpty();
        System.out.println("Is Empty: " + isEmpty); // Is Empty is true

        String someText = "aaa";
        boolean notEmpty = someText.isEmpty();
        System.out.println("Is Empty: " + notEmpty); // Is Empty is false
    }

    private static void endsWith(String sample_text) {
        boolean endsWithWorld = sample_text.endsWith("world!");
        System.out.println("Ends With 'world!': " + endsWithWorld); // false
    }

    private static void startsWith(String sample_text) {
        boolean startsWithHello = sample_text.startsWith("hello");
        System.out.println("Starts With 'hello': " + startsWithHello); // true

        boolean startsWithFromIndex = sample_text.startsWith("he", 0);
        System.out.println("Starts With 'he' from Index 0: " + startsWithFromIndex); // true
    }

    private static void contains(String sample_text) {
        boolean containsWorld = sample_text.contains("World");
        System.out.println("Contains 'World': " + containsWorld); // true

        boolean containsWorld1 = sample_text.contains("world");
        System.out.println("Contains 'world': " + containsWorld1); // false
    }

    private static void equals(String sample_text) {
        String otherString = "Hello, World!";
        boolean isEqual = sample_text.equals(otherString);
        System.out.println("Equals 'Hello, World!': " + isEqual); // false

        String otherString1 = "Hello World";
        boolean isEqual1 = sample_text.equals(otherString1);
        System.out.println("Equals 'Hello World': " + isEqual1); // false

        String otherString2 = "hello world";
        boolean isEqual2 = sample_text.equals(otherString2);
        System.out.println("Equals 'hello world': " + isEqual2); // true

        String otherString3 = "Hello World";
        boolean isEqual3 = sample_text.equalsIgnoreCase(otherString3);
        System.out.println("Equals (ignore case) 'Hello World': " + isEqual3); // true
    }

    private static void concat(String sample_text) {
        String result = sample_text.concat(" Have a nice day!");
        System.out.println("Concatenated: " + result); // "hello world! Have a nice day!"
    }

    private static void toLower(String sample_text) {
        String new_text_lower = sample_text.toLowerCase();
        System.out.println("Lowercase: " + new_text_lower); // "hello world!"
    }

    private static void toUpper(String sample_text) {
        String new_text_upper = sample_text.toUpperCase();
        System.out.println("Uppercase: " + new_text_upper); // "HELLO WORLD!"
    }

    private static void replace(String sample_text) {
        System.out.println("Replace 'o' with 'O': " + sample_text.replace('o', 'O')); // "hellO wOrld!"
        System.out.println("Replace 'hello' with 'ooo': " + sample_text.replace("hello", "ooo")); // "ooo world!"
    }

    private static void trim() {
        String something_to_trim = "    TRIM!!    ";
        System.out.println("Trimmed: " + something_to_trim.trim()); // "TRIM!!"
    }

    private static void length(String sample_text) {
        int string_length = sample_text.length();
        System.out.println("String Length: " + string_length); // 12
    }

    private static void lastCharAt(String sample_text) {
        char last_char = sample_text.charAt(sample_text.length() - 1);
        System.out.println("Last Character: " + last_char); // '!'
    }

    private static void charAt(String sample_text) {
        char second_char = sample_text.charAt(1);
        System.out.println("Second Character: " + second_char); // 'e'
    }

    private static void substring(String sample_text) {
        System.out.println("Substring from index 0 to 5: " + sample_text.substring(0, 5)); // "hello"
        String sample_text_sliced = sample_text.substring(6);
        System.out.println("Substring from index 6 to end: " + sample_text_sliced); // "world!"
    }

}
