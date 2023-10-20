import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListClass {

	public static void main(String[] args) {
		// Create and operate on an ArrayList
		List<String> arrayList = new ArrayList<>(); // ArrayList: A dynamic array-based list with fast random access.

		// Add elements to the ArrayList
		addElementsToList(arrayList);
		// Display the ArrayList
		displayList(arrayList);
		// Remove an element from the ArrayList
		removeElementFromList(arrayList, "Banana");
		// Search for an element in the ArrayList
		searchElementInList(arrayList, "Cherry");
		// Check if the ArrayList is empty
		checkIfListIsEmpty(arrayList);
		// Clear the ArrayList (remove all elements)
		clearList(arrayList);
		// Demonstrate forEach loop on the ArrayList
		forEachExample(arrayList);

		System.out.println();

		// Create and operate on a LinkedList
		List<String> linkedList = new LinkedList<>(); // LinkedList: A doubly-linked list with efficient add/remove
														// operations.

		// Add elements to the LinkedList
		addElementsToList(linkedList);
		// Display the LinkedList
		displayList(linkedList);
		// Remove an element from the LinkedList
		removeElementFromList(linkedList, "Banana");
		// Search for an element in the LinkedList
		searchElementInList(linkedList, "Cherry");
		// Check if the LinkedList is empty
		checkIfListIsEmpty(linkedList);
		// Clear the LinkedList (remove all elements)
		clearList(linkedList);
		// Demonstrate forEach loop on the LinkedList
		forEachExample(linkedList);

		System.out.println();

		// Create and operate on a Vector
		List<String> vector = new Vector<>(); // Vector: A thread-safe dynamic array-based list.

		// Add elements to the Vector
		addElementsToList(vector);
		// Display the Vector
		displayList(vector);
		// Remove an element from the Vector
		removeElementFromList(vector, "Banana");
		// Search for an element in the Vector
		searchElementInList(vector, "Cherry");
		// Check if the Vector is empty
		checkIfListIsEmpty(vector);
		// Clear the Vector (remove all elements)
		clearList(vector);
		// Demonstrate forEach loop on the Vector
		forEachExample(vector);

	}


	public static void addElementsToList(List<String> list) {
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");
		list.add("Date");
	}


	public static void displayList(List<String> list) {
		System.out.println("List: " + list);
	}


	public static void removeElementFromList(List<String> list, String element) {
		list.remove(element);
		System.out.println("Element '" + element + "' removed from the list.");
	}


	public static void searchElementInList(List<String> list, String element) {
		if (list.contains(element)) {
			System.out.println("Element '" + element + "' found in the list.");
		} else {
			System.out.println("Element '" + element + "' not found in the list.");
		}
	}


	public static void checkIfListIsEmpty(List<String> list) {
		if (list.isEmpty()) {
			System.out.println("The list is empty.");
		} else {
			System.out.println("The list is not empty.");
		}
	}


	public static void clearList(List<String> list) {
		list.clear();
		System.out.println("List cleared.");
	}


	public static void forEachExample(List<String> list) {
		System.out.println("Using forEach loop:");
		list.forEach(item -> System.out.println(item));
	}
}
