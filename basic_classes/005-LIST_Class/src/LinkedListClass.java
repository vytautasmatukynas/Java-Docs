import java.util.LinkedList;

public class LinkedListClass {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();

		addElements(linkedList);

		// Get first and last items in list
		System.out.println(getFirstElement(linkedList));
		System.out.println(getLastElement(linkedList));

		// Displaying the linked list
		displayList(linkedList);

		// Removing an element at a specific index
		removeElementAtIndex(linkedList, 2);

		// Searching for an element in the linked list
		searchElement(linkedList, 4);

		// Updating an element at a specific index
		updateElementAtIndex(linkedList, 1, 10);

		// Add an element at the beginning of the linked list
		addElementAtBeginning(linkedList, 0);

		// Add an element at the end of the linked list
		addElementAtEnd(linkedList, 20);

		// poll(): Remove and return the head of the LinkedList
		poll(linkedList);

		// pop(): Remove and return the first element (same as poll())
		pop(linkedList);

		// push(): Add an element to the front of the LinkedList
		push(linkedList);

		// peek(): Retrieve, but do not remove, the head of the LinkedList
		peek(linkedList);

		// Get the size of the linked list
		int size = getSize(linkedList);
		System.out.println("Size of the linked list: " + size);

		// Clear all elements from the linked list
		clearList(linkedList);
		displayList(linkedList);

	}

	public static int getFirstElement(LinkedList<Integer> list) {
		if (list.isEmpty()) {
			throw new IllegalStateException("The linked list is empty.");
		}
		return list.getFirst();
	}

	public static int getLastElement(LinkedList<Integer> list) {
		if (list.isEmpty()) {
			throw new IllegalStateException("The linked list is empty.");
		}
		return list.getLast();
	}

	// Method to add elements to the linked list
	public static void addElements(LinkedList<Integer> list) {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
	}

	private static void peek(LinkedList<Integer> linkedList) {
		int peekedElement = linkedList.peek();
		System.out.println("Peeked Element: " + peekedElement);
		System.out.println("LinkedList after peek: " + linkedList);
	}

	private static void push(LinkedList<Integer> linkedList) {
		linkedList.push(5);
		System.out.println("LinkedList after push: " + linkedList);
	}

	private static void pop(LinkedList<Integer> linkedList) {
		int poppedElement = linkedList.pop();
		System.out.println("Popped Element: " + poppedElement);
		System.out.println("Updated LinkedList: " + linkedList);
	}

	private static void poll(LinkedList<Integer> linkedList) {
		int polledElement = linkedList.poll();
		System.out.println("Polled Element: " + polledElement);
		System.out.println("Updated LinkedList: " + linkedList);
	}

	// Method to display the linked list
	public static void displayList(LinkedList<Integer> list) {
		System.out.println("Linked List: " + list);
	}

	// Method to remove an element at a specific index
	public static void removeElementAtIndex(LinkedList<Integer> list, int index) {
		list.remove(index);
		System.out.println("Element at index " + index + " removed.");
	}

	// Method to search for an element in the linked list
	public static void searchElement(LinkedList<Integer> list, int element) {
		if (list.contains(element)) {
			System.out.println("Element " + element + " found in the linked list.");
		} else {
			System.out.println("Element " + element + " not found in the linked list.");
		}
	}

	// Method to update an element at a specific index
	public static void updateElementAtIndex(LinkedList<Integer> list, int index, int newValue) {
		list.set(index, newValue);
		System.out.println("Element at index " + index + " updated to " + newValue + ".");
	}

	// Method to add an element at the beginning of the linked list
	public static void addElementAtBeginning(LinkedList<Integer> list, int element) {
		list.addFirst(element);
		System.out.println("Element " + element + " added at the beginning.");
	}

	// Method to add an element at the end of the linked list
	public static void addElementAtEnd(LinkedList<Integer> list, int element) {
		list.addLast(element);
		System.out.println("Element " + element + " added at the end.");
	}

	// Method to get the size of the linked list
	public static int getSize(LinkedList<Integer> list) {
		return list.size();
	}

	// Method to clear all elements from the linked list
	public static void clearList(LinkedList<Integer> list) {
		list.clear();
		System.out.println("Linked list cleared.");
	}
}
