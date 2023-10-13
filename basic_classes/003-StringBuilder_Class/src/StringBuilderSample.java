import java.util.HashSet;

public class StringBuilderSample {

	public static void main(String[] args) {

		StringBuilder newString = new StringBuilder("labas rytas labas vakaras");

		// reverse string
		newString.reverse();
		System.out.println(newString);

		// add to string
		newString.append("OOOO");
		System.out.println(newString);

		// add string from index
		newString.insert(5, "OOOO");
		System.out.println(newString);

		// cut string end to 'n' length
		newString.setLength(5);
		System.out.println(newString);
		newString.setLength(10);
		System.out.println(newString);

		StringBuilder newString1 = new StringBuilder("labas rytas labas vakaras");

		// returns string length
		System.out.println(newString1.capacity());
		System.out.println(newString1.length());

		// find index of first string/char in string
		int index = newString1.indexOf("lab");
		System.out.println(index);

		// find index from index 5 from string of string/chat in string
		int index2 = newString1.indexOf("lab", 5);
		System.out.println(index2);

		// find index of last string/char in string
		int index3 = newString1.lastIndexOf("lab");
		System.out.println(index3);

		// get what char is at index
		char index4 = newString1.charAt(4);
		System.out.println(index4);

		// delete part of string
		System.out.println(newString1);
		newString1.delete(4, 15);
		System.out.println(newString1);

		StringBuilder newString2 = new StringBuilder("labas rytas labas vakaras");
		// replace part of string
		System.out.println(newString2);
		newString2.replace(1, 5, "2018");
		newString2.insert(5, "*");
		System.out.println(newString2);

	}

}
