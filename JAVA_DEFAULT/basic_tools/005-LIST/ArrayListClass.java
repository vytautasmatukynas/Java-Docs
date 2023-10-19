import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ArrayListClass {

	public static void main(String[] args) {
		// dynamic array-like structure that can dynamically resize itself as needed

		// Demonstrates converting an array to an ArrayList and printing it
		convertArrayToList();
		
		// Print Collection of any type
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys", "trys"));
		print(sarasas);

		// Demonstrates creating ArrayLists in different ways and printing them
		createList();

		// Demonstrates getting the length of an ArrayList
		listLength();

		// Demonstrates adding elements to an ArrayList
		add();

		// Demonstrates adding all elements from one ArrayList to another
		addAll();

		// Demonstrates removing elements from an ArrayList
		remove();

		// Demonstrates updating an element at a specific index in an ArrayList
		set();

		// Demonstrates removing all occurrences of elements from one ArrayList in
		// another
		removeAll();

		// Demonstrates getting an item by its index in an ArrayList
		getItemByIndex();

		// Demonstrates finding the index of the last and first occurrence of an element
		// in an ArrayList
		indexOf_lastIndexOf();

		// Demonstrates checking if an element or a collection of elements is present in
		// an ArrayList
		contains();

		// Demonstrates comparing two ArrayLists for equality
		equals();

		// Demonstrates clearing and checking if an ArrayList is empty
		clear_isEmpty();

		// Demonstrates removing an element from an ArrayList if it exists
		containRemove();
		
		// Demonstrates converting an ArrayList to an array and printing it
		toArray();

		// Demonstrates using ArrayLists within a list and printing them
		listsInList();

		// Demonstrates creating an ArrayList with elements of different types and
		// printing it
		differentTypesArrayList();

		// Demonstrates iterating through an ArrayList using a lambda expression
		forEachWithLambda();

		// Demonstrates iterating through an ArrayList using a lambda expression
		// (alternative syntax)
		forEachWithLambda2();

		// Demonstrates iterating through an ArrayList using a method reference
		forEachWithClass();

	}
	
	private static void print(Collection<?> collection) {    
	   collection.forEach(item -> System.out.println(item));
	}

	private static void toArray() {
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys", "trys"));
		
		System.out.println(sarasas);
		
		String[] array = sarasas.toArray(new String[0]);
		
		for (String item : array)
			System.out.print(item + " ");
	}

	private static void addAll() {
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys", "trys"));
		
		System.out.println(sarasas);
		
		ArrayList<String> sarasas2 = new ArrayList<>(Arrays.asList("trys", "trys", "trys"));
		
		sarasas.addAll(sarasas2);
		
		System.out.println(sarasas);
	}

	private static void set() {
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys", "trys"));
		
		System.out.println(sarasas);
		
		sarasas.set(0, "newItem");
		
		System.out.println(sarasas);
	}

	private static void removeAll() {
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys", "trys"));
		
		System.out.println(sarasas);
		
		ArrayList<String> sarasas2 = new ArrayList<>(Arrays.asList("trys", "trys", "trys"));
		
		sarasas.removeAll(sarasas2);
		
		System.out.println(sarasas);
	}

	private static void forEachWithClass() {
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys", "trys"));

		sarasas.forEach(ArrayListClass::printUpperCase);
	}

	public static void printUpperCase(String element) {
		String upperCaseElement = element.toUpperCase();
		
		System.out.println(upperCaseElement);
	}

	private static void forEachWithLambda2() {
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys", "trys"));

		sarasas.forEach((element) -> System.out.println(element));
	}

	private static void listsInList() {
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys", "trys"));
		ArrayList<Integer> sarasas2 = new ArrayList<>(Arrays.asList(6, 7, 9, 10));

		ArrayList<ArrayList<?>> newList = new ArrayList<ArrayList<?>>();

		newList.add(sarasas);
		newList.add(sarasas2);

		newList.forEach(lists -> System.out.println(lists));
	}

	private static void differentTypesArrayList() {
		ArrayList<?> sarasas = new ArrayList<>(Arrays.asList(true, "du", 5, "trys", 1.0));
		System.out.println(sarasas);
	}

	private static void listLength() {
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys", "trys"));
		System.out.println(sarasas.size());
	}

	private static void indexOf_lastIndexOf() {
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys", "trys"));

		System.out.println(sarasas.lastIndexOf("trys"));
		System.out.println(sarasas.indexOf("trys"));
	}

	private static void forEachWithLambda() {
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys", "trys"));

		sarasas.forEach(item -> System.out.print(item + " "));
	}

	private static void containRemove() {
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("penki", "desimt", "vienuolika"));

		System.out.println(sarasas);

		if (sarasas.contains("penki"))
			sarasas.remove("penki");

		System.out.println(sarasas);
	}

	private static void contains() {
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys", "trys"));
		ArrayList<String> sarasas2 = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys"));

		System.out.println(sarasas.containsAll(sarasas2));
		System.out.println(sarasas.contains("vienas"));
		System.out.println(sarasas.get(0).contains("vienas"));
	}

	private static void clear_isEmpty() {
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys", "trys"));

		System.out.println(sarasas.isEmpty());

		sarasas.clear();

		System.out.println(sarasas.isEmpty());
	}

	private static void add() {
		ArrayList<String> arrayList = new ArrayList<String>();

		arrayList.add("aaaa");
		arrayList.add("bbbb");
		arrayList.add("cccc");
		arrayList.add(2, "kazkas");

		System.out.println(arrayList);
	}

	private static void equals() {
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys", "trys"));
		ArrayList<String> sarasas2 = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys"));
		ArrayList<String> sarasas3 = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys", "trys"));

		System.out.println(sarasas.get(2).equals("trys"));
		System.out.println(sarasas.get(0).equals("trys"));

		System.out.println(sarasas.equals(sarasas2));
		System.out.println(sarasas.equals(sarasas3));
	}

	private static void getItemByIndex() {
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys", "trys"));
		
		System.out.println(sarasas.get(0));
	}

	private static void remove() {
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("vienas", "du", "trys", "trys", "trys"));
		
		System.out.println(sarasas);

		sarasas.remove("du");
		
		System.out.println(sarasas);

		sarasas.remove(0);
		
		System.out.println(sarasas);
	}

	private static void createList() {
		ArrayList<String> sarasas = new ArrayList<>(Arrays.asList("vienas", "du", "trys"));
		System.out.println(sarasas);

		/*
		 * The @SuppressWarnings("serial") annotation is used in Java to suppress
		 * warnings related to SERIALIZABLE classes. When you declare a class as
		 * SERIALIZABLE in Java, it means that instances of that class can be converted
		 * into a stream of bytes and then reconstructed back into an object. However,
		 * Java's serialization mechanism can sometimes produce warnings, especially
		 * related to compatibility and security concerns.
		 */
		@SuppressWarnings("serial")
		ArrayList<String> sarasas2 = new ArrayList<String>() {
			{
				add("vienas");
				add("du");
				add("trys");
			}
		};
		System.out.println(sarasas2);

		ArrayList<String> sarasas3 = new ArrayList<>(List.of("vienas", "du", "trys"));
		System.out.println(sarasas3);
	}

	private static void convertArrayToList() {
		String[] array = { "apple", "banana", "cherry" };

		// Convert the array to an ArrayList
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));

		// Now, 'arrayList' contains the elements from the 'array'
		System.out.println("ArrayList: " + arrayList);
	}

}
