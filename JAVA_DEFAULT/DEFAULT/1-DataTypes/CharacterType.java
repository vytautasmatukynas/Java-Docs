
public class CharacterType {

	public static void methods() {
        char ch = 'A';

        // Check if the character is a letter
        boolean isLetter = Character.isLetter(ch);

        // Check if the character is a digit
        boolean isDigit = Character.isDigit(ch);

        // Check if the character is a whitespace character
        boolean isWhitespace = Character.isWhitespace(ch);

        // Check if the character is in uppercase
        boolean isUpperCase = Character.isUpperCase(ch);

        // Check if the character is in lowercase
        boolean isLowerCase = Character.isLowerCase(ch);

        // Convert the character to uppercase
        char upperCase = Character.toUpperCase(ch);

        // Convert the character to lowercase
        char lowerCase = Character.toLowerCase(ch);

        // Get the numeric value of the character, if it's a digit (e.g., '1' -> 1)
        int numericValue = Character.getNumericValue(ch);

        // Compare two characters lexicographically and return the difference
        int comparison = Character.compare('A', 'B');

        // Check if the character is a letter or a digit
        boolean isLetterOrDigit = Character.isLetterOrDigit(ch);

        System.out.println("isLetter: " + isLetter);
        System.out.println("isDigit: " + isDigit);
        System.out.println("isWhitespace: " + isWhitespace);
        System.out.println("isUpperCase: " + isUpperCase);
        System.out.println("isLowerCase: " + isLowerCase);
        System.out.println("Uppercase: " + upperCase);
        System.out.println("Lowercase: " + lowerCase);
        System.out.println("Numeric Value: " + numericValue);
        System.out.println("Comparison: " + comparison);
        System.out.println("isLetterOrDigit: " + isLetterOrDigit);
	}
}
