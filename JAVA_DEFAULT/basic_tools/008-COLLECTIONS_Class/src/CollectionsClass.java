import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsClass {

	public static void main(String[] args) {
		// Creating sample collections
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve"));

		// Creating sample collections
		List<String> list = new ArrayList<>(Arrays.asList("Alice", "Alice", "Bob", "Charlie", "David", "Eve"));
		Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
		Map<String, Integer> map = new HashMap<>();
		map.put("Alice", 25);
		map.put("Bob", 30);
		map.put("Charlie", 28);
		map.put("David", 35);
		map.put("Eve", 22);

		sort(list);

		shuffle(list);

		reverse(list);

		findMinMaxValues(list);

//		copy(list);

		getHowManyelEmentsThereIs(list);

		checkForSameElements(list, set);

		findElementIndex(list);
		
		addAll(names);

		replaceAll(names);

		findOccurrence(names);

		fillCollection(numbers);

		rotateCollection(names);

		enumerationForCollection(numbers);
		
		rotateListElements(list);

		unmodifiableMap();

		unmodifiableCollection(list, set);

		threadSafeCollection(list);

		threadSafeMap();

		threadSafeCollection();

	}

	private static void threadSafeMap() {
		// Creating a synchronized view of a Map
		Map<String, Integer> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
	}

	private static void enumerationForCollection(List<Integer> numbers) {
		// Creating an Enumeration from an Iterator
		Enumeration<Integer> enumeration = Collections.enumeration(numbers);
	}

	private static void rotateCollection(List<String> names) {
		// Rotating elements within a specified range in a List
		Collections.rotate(names.subList(1, 4), 2);
		System.out.println("Rotated elements in the sublist: " + names);
	}

	private static void findOccurrence(List<String> names) {
		// Finding the first occurrence of an element in a Collection
		int firstOccurrence = Collections.indexOfSubList(names, Arrays.asList("David", "Eve"));
		System.out.println("First occurrence of 'David' and 'Eve': " + firstOccurrence);
	}

	private static void replaceAll(List<String> names) {
		// Removing all occurrences of an element from a Collection
		Collections.replaceAll(names, "Alice", "Alicia");
		System.out.println("Replaced 'Alice' with 'Alicia': " + names);
	}

	private static void unmodifiableMap() {
		// Getting an unmodifiable view of a Map
		Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(new HashMap<>());
	}

	private static void addAll(List<String> names) {
		// Adding multiple elements to a collection
		Collections.addAll(names, "Frank", "Grace");
		System.out.println("Updated names list: " + names);
	}

	private static void fillCollection(List<Integer> numbers) {
		// Filling a list with a specified value
		Collections.fill(numbers, 0);
		System.out.println("Filled list: " + numbers);
	}

	private static void threadSafeCollection() {
		// Creating an empty synchronized collection
		Collection<Integer> synchronizedCollection = Collections.synchronizedCollection(new ArrayList<>());
	}

	private static void rotateListElements(List<String> list) {
		// Rotating elements in a List
		List<String> list2 = new ArrayList<>(Arrays.asList("Alice", "Alice", "Bob", "Charlie", "David", "Eve"));
		Collections.rotate(list2, 2);
		System.out.println("Rotated list: " + list);
	}

	private static void findElementIndex(List<String> list) {
		// Finding the index of an element in a List
		int index = Collections.binarySearch(list, "Charlie");
		System.out.println("Index of 'Charlie': " + index);
	}

	private static void checkForSameElements(List<String> list, Set<Integer> set) {
		// Checking if two Collections have any elements in common
		boolean disjoint = Collections.disjoint(list, set);
		System.out.println("Disjoint: " + disjoint);
	}

	private static void getHowManyelEmentsThereIs(List<String> list) {
		// Frequency of an element in a Collection
		int frequency = Collections.frequency(list, "Alice");
		System.out.println("Frequency of 'Alice': " + frequency);
	}

	private static void copy(List<String> list) {
		// Copying elements from one Collection to another
		List<String> copyList = new ArrayList<>();
		Collections.copy(copyList, list);
		System.out.println("Copied list: " + copyList);
	}

	private static void threadSafeCollection(List<String> list) {
		// Synchronizing a Collection to make it thread-safe
		Collection<String> synchronizedList = Collections.synchronizedCollection(list);
	}

	private static void unmodifiableCollection(List<String> list, Set<Integer> set) {
		// Creating an unmodifiable Collection (Immutable)
		List<String> unmodifiableList = Collections.unmodifiableList(list);
		Set<Integer> unmodifiableSet = Collections.unmodifiableSet(set);
	}

	private static void findMinMaxValues(List<String> list) {
		// Finding the minimum and maximum elements in a Collection
		String min = Collections.min(list);
		String max = Collections.max(list);
		System.out.println("Min: " + min);
		System.out.println("Max: " + max);
	}

	private static void reverse(List<String> list) {
		// Reversing a List
		Collections.reverse(list);
		System.out.println("Reversed list: " + list);
	}

	private static void shuffle(List<String> list) {
		// Shuffling a List (Randomly reorders the elements)
		Collections.shuffle(list);
		System.out.println("Shuffled list: " + list);
	}

	private static void sort(List<String> list) {
		// Sorting a List
		Collections.sort(list);
		System.out.println("Sorted list: " + list);
	}

}
