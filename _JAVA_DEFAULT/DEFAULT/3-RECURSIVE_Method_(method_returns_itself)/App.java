/**
 * This program demonstrates a recursive method for calculating the sum of
 * elements in an array. Recursion is a technique in programming where a
 * methods calls itself to solve a problem by breaking it down into smaller,
 * similar subproblems. In this example, we use recursion to sum the elements of
 * an array.
 */
public class App {
	
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5 };
		int sum = calculateSum(numbers, 0);
		System.out.println("Sum of the elements in the array is: " + sum);
	}

	// A recursive method that calculates the sum of elements in an array.
	public static int calculateSum(int[] arr, int index) {
		if (index >= arr.length) {
			return 0; // Base case: if the index is out of bounds, return 0.
		} else {
			return arr[index] + calculateSum(arr, index + 1); // Recursive case: add the current element and call the
																// function on the next index.
		}
	}
	
}
