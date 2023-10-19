import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArraysClass {

	public static void main(String[] args) {

		Random random = new Random();
		
		emptyArray();
		arrayMatrix();
		arrayWithVariables();

		// Create new array
		int[] arrayA = new int[5];

		// Fill array with random integers
		fillRandomInt(random, arrayA);

		// Sort array
		sort(arrayA);

		// creates array copy with new 'n' length
		int[] arrayB = copyArray(arrayA);

		// creates array copy from some point in array you want to copy with new 'n'
		// length
		// copy starts from 'arrayB[2]' and creates array with length 10
		int[] arrayD = copyArrayPart(arrayB);

		// changes all values of array to 'n'
		// here it fills with '10'
		fill(arrayD);

		// converts array to string
		convert(arrayB);

		// creates List of Array objects
		listOfArrays(arrayA, arrayB, arrayD);

		// check if 2 arrays are equal
		equal(arrayA);

		// result is -1, because first array is shorter then second array
		// if arrays are same length and one arrayA would have smaller values it would
		// be -1 also
		// checks arrays in lexicographical order (ASC order)
		compare(arrayA, arrayB);

		// returns index number of first array items that mismatch
		compareArrayElements(arrayA, arrayB);

	}
	
	private static void arrayMatrix() {
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

	private static void arrayWithVariables() {
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

	private static void emptyArray() {
		// Can define list fixed length
		// this will create list with 'null'
		int[] skaiciai = new int[6];
		// change value of first list item
		skaiciai[0] = 5;
		for (int i : skaiciai)
			System.out.println(i);
	}

	private static void compareArrayElements(int[] arrayA, int[] arrayB) {
		int valueMismatch = Arrays.mismatch(arrayA, arrayB);
		
		System.out.println(valueMismatch);
		
		System.out.println("------");
	}

	private static void compare(int[] arrayA, int[] arrayB) {
		System.out.println(Arrays.compare(arrayA, arrayB));
		
		System.out.println(Arrays.compare(arrayB, arrayB));
		
		System.out.println(Arrays.compare(arrayB, arrayA));
		
		System.out.println("------");
	}

	private static void equal(int[] arrayA) {
		boolean valueEquals = Arrays.equals(arrayA, arrayA);
		
		System.out.println(valueEquals);
		
		System.out.println("------");
	}

	private static void listOfArrays(int[] arrayA, int[] arrayB, int[] arrayD) {
		List<int[]> listA = Arrays.asList(arrayA, arrayB, arrayD);
		
		print(listA);
		
		List<int[]> listD = List.of(arrayA, arrayB, arrayD);
		
		print(listD);
	}

	private static void convert(int[] arrayB) {
		String arrayC = Arrays.toString(arrayB);
		
		print(arrayC);
	}

	private static void fill(int[] arrayD) {
		Arrays.fill(arrayD, 10);
		
		print(arrayD);
	}

	private static int[] copyArrayPart(int[] arrayB) {
		int[] arrayD = Arrays.copyOfRange(arrayB, 2, 10);
		
		print(arrayD);
		
		return arrayD;
	}

	private static int[] copyArray(int[] arrayA) {
		int[] arrayB = Arrays.copyOf(arrayA, 6);
		print(arrayB);
		return arrayB;
	}

	private static void sort(int[] arrayA) {
		Arrays.sort(arrayA);
		
		print(arrayA);

		Arrays.parallelSort(arrayA);
		
		print(arrayA);
	}

	private static void fillRandomInt(Random random, int[] arrayA) {
		for (int i = 0; i < arrayA.length; i++) {
			int randInt = random.nextInt(75);
			
			arrayA[i] = randInt;
		}

		print(arrayA);
	}

	// method to print String
	private static void print(String value) {
		System.out.print(value);
		
		System.out.println("\n------");
	}

	// method to print List
	private static void print(List<int[]> list) {
		for (int[] item1 : list) {
			for (int item2 : item1) {
				System.out.print(item2 + " ");
			}
			System.out.println("\n-");
		}
		
		System.out.println("------");
	}

	// method to print Array
	private static void print(int[] array) {
		for (int item : array) {
			System.out.print(item + " ");
		}
		
		System.out.println("\n------");
	}

}
