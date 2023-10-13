import java.util.Arrays;

public class Array {


	public static void main(String[] args) {
		
		int a = 0;
		int b = 0;
		if (++a == 1 || ++b == 1) {
		 a += 1;
		 b += 1;
		}
		System.out.println("a=" + a + ", b=" + b);

		stringList();
		emptyList2();
		emptyList();
		arrayMatrica();
		arraysClassMethods();

	}

	private static void arraysClassMethods() {
		String[] text2 = { "zzzz", "aaaa", "rrrr" };
		String arrayToString = Arrays.toString(text2);
		System.out.println(arrayToString);

		int[] num2 = { 1, 9, 3 };
		Arrays.sort(num2);
		String arrayToStringNum = Arrays.toString(num2);
		System.out.println(arrayToStringNum);
	}

	private static void arrayMatrica() {
		// 2D array
//		int [][] matrica = new int[4][4];;
		int[][] matrica = { { 5, 6, 7, 8 }, { 5, 6, 7, 8 }, { 5, 6, 7, 8 }, { 5, 6, 7, 8 } };

		System.out.println(matrica[1][2]);

		for (int y = 0; y < matrica.length; y++) {
			for (int x = 0; x < matrica[0].length; x++) {
				System.out.print(matrica[x][y]);
			}
		}
	}

	private static void stringList() {
		// this will create list with String
		String[] text2 = { "zzzz", "aaaa", "rrrr" };
		// print list items in one line
		for (String i : text2)
			System.out.print(i + " ");

		System.out.print("\n");

		// change value of second list item
		text2[1] = "oooo";
		for (String i : text2)
			System.out.println(i);
	}

	private static void emptyList2() {
		// this will create list with 'null'
		String[] text = new String[8];
		// change value of fifth list item
		text[4] = "oooo";
		for (String i : text)
			System.out.println(i);
	}

	private static void emptyList() {
		// Can define list fixed length
		// this will create list with 'null'
		int[] skaiciai = new int[6];
		// change value of first list item
		skaiciai[0] = 5;
		for (int i : skaiciai)
			System.out.println(i);
	}

}
