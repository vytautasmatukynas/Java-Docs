import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Set;

public class SetClass {

	public static void main(String[] args) {
		// Create and operate on a HashSet
		Set<String> hashSet = new HashSet<>(); // HashSet: An unordered set that uses a hash table for storage.

		// Add elements to the HashSet
		addElementsToSet(hashSet);

		// Display the HashSet
		displaySet(hashSet);

		// Remove an element from the HashSet
		removeElementFromSet(hashSet, "Banana");

		// Search for an element in the HashSet
		searchElementInSet(hashSet, "Cherry");

		// Check if the HashSet is empty
		checkIfSetIsEmpty(hashSet);

		// Clear the HashSet (remove all elements)
		clearSet(hashSet);

		System.out.println();

		// Create and operate on a LinkedHashSet
		Set<String> linkedHashSet = new LinkedHashSet<>(); // LinkedHashSet: A set that maintains the order of
															// insertion.

		// Add elements to the LinkedHashSet
		addElementsToSet(linkedHashSet);

		// Display the LinkedHashSet
		displaySet(linkedHashSet);

		// Remove an element from the LinkedHashSet
		removeElementFromSet(linkedHashSet, "Banana");

		// Search for an element in the LinkedHashSet
		searchElementInSet(linkedHashSet, "Cherry");

		// Check if the LinkedHashSet is empty
		checkIfSetIsEmpty(linkedHashSet);

		// Clear the LinkedHashSet (remove all elements)
		clearSet(linkedHashSet);

		System.out.println();

		// Create and operate on a TreeSet
		Set<String> treeSet = new TreeSet<>(); // TreeSet: An ordered set that stores elements in sorted order.

		// Add elements to the TreeSet
		addElementsToSet(treeSet);

		// Display the TreeSet
		displaySet(treeSet);

		// Remove an element from the TreeSet
		removeElementFromSet(treeSet, "Banana");

		// Search for an element in the TreeSet
		searchElementInSet(treeSet, "Cherry");

		// Check if the TreeSet is empty
		checkIfSetIsEmpty(treeSet);

		// Clear the TreeSet (remove all elements)
		clearSet(treeSet);
		
		//
		forEachExample(treeSet);
	}

	// Method to add elements to a Set
	public static void addElementsToSet(Set<String> set) {
		set.add("Apple");
		set.add("Banana");
		set.add("Cherry");
		set.add("Date");
	}

	// Method to display the elements in a Set
	public static void displaySet(Set<String> set) {
		System.out.println("Set: " + set);
	}

	// Method to remove an element from a Set
	public static void removeElementFromSet(Set<String> set, String element) {
		set.remove(element);
		
		System.out.println("Element '" + element + "' removed from the set.");
	}

	// Method to search for an element in a Set
	public static void searchElementInSet(Set<String> set, String element) {
		if (set.contains(element)) {
			System.out.println("Element '" + element + "' found in the set.");
			
		} else {
			System.out.println("Element '" + element + "' not found in the set.");
		}
	}

	// Method to check if a Set is empty
	public static void checkIfSetIsEmpty(Set<String> set) {
		if (set.isEmpty()) {
			System.out.println("The set is empty.");
			
		} else {
			System.out.println("The set is not empty.");
		}
	}

	// Method to clear a Set (remove all elements)
	public static void clearSet(Set<String> set) {
		set.clear();
		
		System.out.println("Set cleared.");
	}

	// Method to demonstrate using forEach on a Set
	public static void forEachExample(Set<String> set) {
		System.out.println("Using forEach on the Set:");
		
		set.forEach(element -> System.out.println("Element: " + element));
	}

}
