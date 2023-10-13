import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArraysClass {

	public static void main(String[] args) {

		// Reference to Random class
		Random random = new Random();

		// Create new array
		int[] arrayA = new int[5];

		// Fill array with random integers
		for (int i = 0; i < arrayA.length; i++) {
			int randInt = random.nextInt(75);
			arrayA[i] = randInt;
		}

		print(arrayA);

		// Sort array
		Arrays.sort(arrayA);
		;
		print(arrayA);

		Arrays.parallelSort(arrayA);
		print(arrayA);

		// creates array copy with new 'n' length
		int[] arrayB = Arrays.copyOf(arrayA, 6);
		print(arrayB);

		// creates array copy from some point in array you want to copy with new 'n'
		// length
		// copy starts from 'arrayB[2]' and creates array with length 10
		int[] arrayD = Arrays.copyOfRange(arrayB, 2, 10);
		print(arrayD);

		// changes all values of array to 'n'
		// here it fills with '10'
		Arrays.fill(arrayD, 10);
		print(arrayD);

		// converts array to string
		String arrayC = Arrays.toString(arrayB);
		print(arrayC);

		// creates List of Array objects
		List<int[]> listA = Arrays.asList(arrayA, arrayB, arrayD);
		print(listA);

		// check if 2 arrays are equal
		boolean valueEquals = Arrays.equals(arrayA, arrayA);
		System.out.println(valueEquals);
		System.out.println("------");

		// result is -1, because first array is shorter then second array
		// if arrays are same length and one arrayA would have smaller values it would
		// be -1 also
		// checks arrays in lexicographical order (ASC order)
		System.out.println(Arrays.compare(arrayA, arrayB));
		System.out.println(Arrays.compare(arrayB, arrayB));
		System.out.println(Arrays.compare(arrayB, arrayA));
		System.out.println("------");

		// returns index number of first array items that mismatch
		int valueMismatch = Arrays.mismatch(arrayA, arrayB);
		System.out.println(valueMismatch);
		System.out.println("------");

	}

	// method to print String
	private static void print(String value) {
		System.out.print(value);
		System.out.println("\n------");
	}

	// method to print list
	private static void print(List<int[]> list) {
		for (int[] item1 : list) {
			for (int item2 : item1) {
				System.out.print(item2 + " ");
			}
			System.out.println("\n-");
		}
		System.out.println("------");
	}

	// method to print array
	private static void print(int[] array) {
		for (int item : array) {
			System.out.print(item + " ");
		}
		System.out.println("\n------");
	}

}
