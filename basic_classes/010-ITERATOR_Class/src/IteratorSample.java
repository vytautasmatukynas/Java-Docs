import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class IteratorSample {

	public static void main(String[] args) {

		iteratorNext();
		iteratorHasNext();

		list();
		toList();
		listIterator();

		set();
		toSet();

		map();
		toMap();

	}

	private static void listIterator() {
		List<String> list = new ArrayList<>();

		// Adding elements to the list
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("Four");
		list.add("Five");

		// Creating a ListIterator
		ListIterator<String> iterator = list.listIterator();

		// Forward iteration
		System.out.println("Forward iteration:");
		while (iterator.hasNext()) {
			String item = iterator.next();
			System.out.println(item);
		}

		// Backward iteration
		System.out.println("\nBackward iteration:");
		while (iterator.hasPrevious()) {
			String item = iterator.previous();
			System.out.println(item);
		}

		// Modifying elements while iterating
		System.out.println("\nModifying elements while iterating:");
		iterator = list.listIterator();
		while (iterator.hasNext()) {
			String item = iterator.next();
			if (item.equals("Three")) {
				iterator.set("3"); // Replace "Three" with "3"
			} else if (item.equals("Four")) {
				iterator.remove(); // Remove "Four"
			}
		}

		// Printing the modified list
		System.out.println(list);

		// Forward iteration with next and previous indices
		System.out.println("Forward iteration:");
		while (iterator.hasNext()) {
			int nextIndex = iterator.nextIndex();
			int previousIndex = iterator.previousIndex();
			String item = iterator.next();
			System.out
					.println("Next Index: " + nextIndex + ", Previous Index: " + previousIndex + ", Element: " + item);
		}

		// Backward iteration with next and previous indices
		System.out.println("\nBackward iteration:");
		while (iterator.hasPrevious()) {
			int nextIndex = iterator.nextIndex();
			int previousIndex = iterator.previousIndex();
			String item = iterator.previous();
			System.out
					.println("Next Index: " + nextIndex + ", Previous Index: " + previousIndex + ", Element: " + item);
		}
	}

	private static void iteratorNext() {
		// Creating an ArrayList
		// (Declaring ArrayList of String type)
		ArrayList<String> list = new ArrayList<String>();

		// Adding elements to above List at
		// the end of the list
		// Custom inputs
		list.add("Element1");
		list.add("Element2");
		list.add("Element3");

		// Declaring the Iterator
		Iterator<String> iterator = list.iterator();

		// Printing values showcasing next() method which
		// shows traversal over elements
		// only in forward direction

		// Prints first element traversed
		System.out.println(iterator.next());

		// Prints the succeeding element
		System.out.println(iterator.next());

		// Prints another element succeeding
		// to previous element
		System.out.println(iterator.next());
	}

	private static void iteratorHasNext() {
		// Creating an ArrayList
		// Declaring the ArrayList
		ArrayList<String> list = new ArrayList<String>();

		// Adding (appending) new elements at
		// the end of the List
		// Custom inputs
		list.add("Geeks");
		list.add("for Geeks");

		// Declaring the Iterator
		Iterator<String> iterator = list.iterator();

		// Printing hasNext() values
		// Prints true because iterator has two more values
		System.out.println(iterator.hasNext());

		// Go to next value using next() method
		iterator.next();

		// Prints true because iterator has one more values
		System.out.println(iterator.hasNext());

		// Go to next value using next() method
		iterator.next();

		// Prints false because iterator has no more values
		System.out.println(iterator.hasNext());
	}

	private static void toMap() {
		Map<String, Integer> map = new HashMap<>();

		map.put("Alice", 25);
		map.put("Bob", 30);
		map.put("Charlie", 35);

		// Create an Iterator with key-value pairs
		Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

		// Convert the Iterator to a new Map
		Map<String, Integer> newMap = new HashMap<>();

		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			newMap.put(entry.getKey(), entry.getValue());
		}

		// Print the new Map
		for (Map.Entry<String, Integer> entry : newMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	private static void toList() {
		List<String> myList = new ArrayList<>();

		myList.add("Apple");
		myList.add("Banana");
		myList.add("Cherry");

		// Create an Iterator from the List
		Iterator<String> iterator = myList.iterator();

		// Convert the Iterator to a new List
		List<String> newList = new ArrayList<>();

		iterator.forEachRemaining(newList::add);

		newList.forEach(word -> System.out.println(word));

		// <OR>

		List<String> newList2 = new ArrayList<>();

		iterator.forEachRemaining(word -> {
			newList2.add(word);
		});

		newList2.forEach(word -> System.out.println(word));

		// <OR>

		List<String> newList3 = new ArrayList<>();

		while (iterator.hasNext()) {
			newList3.add(iterator.next());
		}

		for (String fruit : newList3) {
			System.out.println(fruit);
		}
	}

	private static void toSet() {
		Set<Integer> mySet = new HashSet<>();

		mySet.add(1);
		mySet.add(2);
		mySet.add(3);

		// Create an Iterator from the Set
		Iterator<Integer> iterator = mySet.iterator();

		// Convert the Iterator to a new Set
		Set<Integer> newSet = new HashSet<>();

		iterator.forEachRemaining(newSet::add);

		newSet.forEach(number -> System.out.println(number));

		// <OR>

		Set<Integer> newSet2 = new HashSet<>();

		iterator.forEachRemaining(item -> {
			newSet2.add(item);
		});

		newSet2.forEach(number -> System.out.println(number));

		// <OR>

		Set<Integer> newSet3 = new HashSet<>();

		while (iterator.hasNext()) {
			newSet3.add(iterator.next());
		}

		for (Integer number : newSet3) {
			System.out.println(number);
		}
	}

	private static void map() {
		Map<String, Integer> ages = new HashMap<>();

		ages.put("Alice", 25);
		ages.put("Bob", 30);
		ages.put("Charlie", 35);

		// Using an iterator to iterate over entries (key-value pairs)
		Iterator<Map.Entry<String, Integer>> iterator = ages.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();

			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	private static void set() {
		Set<Integer> numbers = new HashSet<>();

		numbers.add(1);
		numbers.add(2);
		numbers.add(3);

		// Using an iterator
		Iterator<Integer> iterator = numbers.iterator();

		while (iterator.hasNext()) {
			Integer number = iterator.next();

			System.out.println(number);
		}
	}

	private static void list() {
		List<String> fruits = new ArrayList<>();

		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Cherry");

		// Using an iterator
		Iterator<String> iterator = fruits.iterator();

		while (iterator.hasNext()) {
			String fruit = iterator.next();

			System.out.println(fruit);
		}
	}

}
