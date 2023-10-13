
public class StringBufferClass {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer("Hello");

		// Append some text
		appendText(sb, " World");
		System.out.println("After appending: " + sb);

		// Insert text at a specific position
		insertText(sb, 5, "Beautiful ");
		System.out.println("After inserting: " + sb);

		// Delete a portion of the text
		deleteText(sb, 5, 15);
		System.out.println("After deleting: " + sb);

		// Replace a portion of the text
		replaceText(sb, 6, 11, "Java");
		System.out.println("After replacing: " + sb);

		// Reverse the text
		reverseText(sb);
		System.out.println("After reversing: " + sb);

		// Get the length of the StringBuffer
		int length = getLength(sb);
		System.out.println("Length of the StringBuffer: " + length);

		// Convert StringBuffer to String
		String result = convertToString(sb);
		System.out.println("Converted to String: " + result);

		// Set the length of the StringBuffer
		setLength(sb, 10);
		System.out.println("After setting length: " + sb);

		// Ensure capacity of the StringBuffer
		ensureCapacity(sb, 20);
		System.out.println("After ensuring capacity: " + sb);

		// Get the capacity of the StringBuffer
		int capacity = getCapacity(sb);
		System.out.println("Capacity of the StringBuffer: " + capacity);

		// Get the character at a specific index
		char charAtIndex = getCharAtIndex(sb, 2);
		System.out.println("Character at index 2: " + charAtIndex);

		// Append multiple values of different types
		appendMultipleValues(sb, 123, true, 4.56);
		System.out.println("After appending multiple values: " + sb);

	}

	// Append text to the StringBuffer
	public static void appendText(StringBuffer sb, String str) {
		sb.append(str);
	}

	// Insert text into the StringBuffer at a specific position
	public static void insertText(StringBuffer sb, int index, String str) {
		sb.insert(index, str);
	}

	// Delete a portion of the text from the StringBuffer
	public static void deleteText(StringBuffer sb, int start, int end) {
		sb.delete(start, end);
	}

	// Replace a portion of the text in the StringBuffer
	public static void replaceText(StringBuffer sb, int start, int end, String replacement) {
		sb.replace(start, end, replacement);
	}

	// Reverse the text in the StringBuffer
	public static void reverseText(StringBuffer sb) {
		sb.reverse();
	}

	// Get the length of the StringBuffer
	public static int getLength(StringBuffer sb) {
		return sb.length();
	}

	// Convert StringBuffer to String
	public static String convertToString(StringBuffer sb) {
		return sb.toString();
	}

	// Set the length of the StringBuffer
	public static void setLength(StringBuffer sb, int length) {
		sb.setLength(length);
	}

	// Capacity in a StringBuffer refers to the number of characters that it can hold without needing to allocate more memory
	// Ensure capacity of the StringBuffer
	public static void ensureCapacity(StringBuffer sb, int minimumCapacity) {
		sb.ensureCapacity(minimumCapacity);
	}

	// Get the capacity of the StringBuffer
	public static int getCapacity(StringBuffer sb) {
		return sb.capacity();
	}

	// Get the character at a specific index
	public static char getCharAtIndex(StringBuffer sb, int index) {
		return sb.charAt(index);
	}

	// Append multiple values of different types
	public static void appendMultipleValues(StringBuffer sb, int intValue, boolean boolValue, double doubleValue) {
		sb.append(" Int: ").append(intValue).append(" Bool: ").append(boolValue).append(" Double: ")
				.append(doubleValue);
	}

}
