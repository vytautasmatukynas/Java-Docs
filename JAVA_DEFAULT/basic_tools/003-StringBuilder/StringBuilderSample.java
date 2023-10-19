

public class StringBuilderSample {

	public static void main(String[] args) {

		StringBuilder newString = new StringBuilder("labas rytas labas vakaras");

		// reverse string
		reverse(newString);

		// add to string
		append(newString);

		// add string from index
		insert(newString);

		// cut string end to 'n' length
		changeLength(newString);

		StringBuilder newString1 = new StringBuilder("labas rytas labas vakaras");

		// returns string length
		length(newString1);

		// find index of first string/char in string
		findIndex(newString1);

		// find index from index 5 from string of string/chat in string
		findIndexFrom(newString1);

		// find index of last string/char in string
		findLastIndex(newString1);

		// get what char is at index
		getChar(newString1);

		// delete part of string
		deleteString(newString1);

		StringBuilder newString2 = new StringBuilder("labas rytas labas vakaras");
		// replace part of string
		replaceString(newString2);

	}

	private static void replaceString(StringBuilder newString2) {
		System.out.println(newString2);
		newString2.replace(1, 5, "2018");
		newString2.insert(5, "*");
		System.out.println(newString2);
	}

	private static void deleteString(StringBuilder newString1) {
		System.out.println(newString1);
		newString1.delete(4, 15);
		System.out.println(newString1);
	}

	private static void getChar(StringBuilder newString1) {
		char index4 = newString1.charAt(4);
		System.out.println(index4);
	}

	private static void findLastIndex(StringBuilder newString1) {
		int index3 = newString1.lastIndexOf("lab");
		System.out.println(index3);
	}

	private static void findIndexFrom(StringBuilder newString1) {
		int index2 = newString1.indexOf("lab", 5);
		System.out.println(index2);
	}

	private static void findIndex(StringBuilder newString1) {
		int index = newString1.indexOf("lab");
		System.out.println(index);
	}

	private static void length(StringBuilder newString1) {
		System.out.println(newString1.capacity());
		System.out.println(newString1.length());
	}

	private static void changeLength(StringBuilder newString) {
		newString.setLength(5);
		System.out.println(newString);
		newString.setLength(10);
		System.out.println(newString);
	}

	private static void insert(StringBuilder newString) {
		newString.insert(5, "OOOO");
		System.out.println(newString);
	}

	private static void append(StringBuilder newString) {
		newString.append("OOOO");
		System.out.println(newString);
	}

	private static void reverse(StringBuilder newString) {
		newString.reverse();
		System.out.println(newString);
	}

}
