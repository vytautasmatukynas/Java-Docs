import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapClass {

	public static void main(String[] args) {
		// Create and operate on a HashMap
		Map<String, Integer> hashMap = new HashMap<>(); // HashMap: An unordered map that uses a hash table for storage.

		// Add entries to the HashMap
		addEntriesToMap(hashMap);
		
		// Print any type MAP
		print(hashMap);

		// Display the HashMap
		displayMap(hashMap);

		// Remove an entry from the HashMap
		removeEntryFromMap(hashMap, "Banana");

		// Search for a key in the HashMap
		searchForKeyInMap(hashMap, "Cherry");

		// Check if the HashMap is empty
		checkIfMapIsEmpty(hashMap);

		// Clear the HashMap (remove all entries)
		clearMap(hashMap);

		System.out.println();

		// Create and operate on a LinkedHashMap
		Map<String, Integer> linkedHashMap = new LinkedHashMap<>(); // LinkedHashMap: A map that maintains the order of
																	// insertion.

		// Add entries to the LinkedHashMap
		addEntriesToMap(linkedHashMap);

		// Display the LinkedHashMap
		displayMap(linkedHashMap);

		// Remove an entry from the LinkedHashMap
		removeEntryFromMap(linkedHashMap, "Banana");

		// Search for a key in the LinkedHashMap
		searchForKeyInMap(linkedHashMap, "Cherry");

		// Check if the LinkedHashMap is empty
		checkIfMapIsEmpty(linkedHashMap);

		// Clear the LinkedHashMap (remove all entries)
		clearMap(linkedHashMap);

		System.out.println();

		// Create and operate on a TreeMap
		Map<String, Integer> treeMap = new TreeMap<>(); // TreeMap: A map that stores entries in sorted order.

		// Add entries to the TreeMap
		addEntriesToMap(treeMap);

		// Display the TreeMap
		displayMap(treeMap);

		// Remove an entry from the TreeMap
		removeEntryFromMap(treeMap, "Banana");

		// Search for a key in the TreeMap
		searchForKeyInMap(treeMap, "Cherry");

		// Check if the TreeMap is empty
		checkIfMapIsEmpty(treeMap);

		// Clear the TreeMap (remove all entries)
		clearMap(treeMap);

		System.out.println();

		// Demonstrate using forEach on the TreeMap
		forEachExample(treeMap);

		// Demonstrate getting keys and values
		getKeySet(treeMap);
		getValueCollection(treeMap);
		getKeysAndValues(treeMap);

		// Add all entries from one map to another
		Map<String, Integer> sourceMap = new HashMap<>();
		sourceMap.put("Orange", 5);
		sourceMap.put("Grape", 6);
		addAllEntriesFromMap(hashMap, sourceMap);

		// Display the updated HashMap
		displayMap(hashMap);

		// Remove all entries in one map that are also in another map
		removeAllEntriesInCommon(hashMap, sourceMap);
		
		// Convert MAP to LIST
        convertToListValues();
        
		convertToList();
		
		
	}
	
    private static void print(Map<?, ?> map) {
        map.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

	private static void convertToListValues() {
		Map<String, Integer> ageMap = new HashMap<>();
        ageMap.put("Alice", 25);
        ageMap.put("Bob", 30);
        ageMap.put("Charlie", 28);

        // Convert values to a List
        List<Integer> valueList = new ArrayList<>(ageMap.values());

        // Print the List of values
        System.out.println("List of values: " + valueList);
	}

	private static void convertToList() {
		Map<String, Integer> ageMap = new HashMap<>();
        ageMap.put("Alice", 25);
        ageMap.put("Bob", 30);
        ageMap.put("Charlie", 28);

        // Convert key-value pairs to a List
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(ageMap.entrySet());

        // Print the List of key-value pairs
        System.out.println("List of key-value pairs: " + entryList);
	}

	// Method to add entries to a Map
	public static void addEntriesToMap(Map<String, Integer> map) {
		map.put("Apple", 1);
		map.put("Banana", 2);
		map.put("Cherry", 3);
		map.put("Date", 4);
	}

	// Method to display the entries in a Map
	public static void displayMap(Map<String, Integer> map) {
		System.out.println("Map: " + map);
	}

	// Method to remove an entry from a Map
	public static void removeEntryFromMap(Map<String, Integer> map, String key) {
		map.remove(key);
		
		System.out.println("Entry with key '" + key + "' removed from the map.");
	}

	// Method to search for a key in a Map
	public static void searchForKeyInMap(Map<String, Integer> map, String key) {
		if (map.containsKey(key)) {
			System.out.println("Key '" + key + "' found in the map.");
			
		} else {
			System.out.println("Key '" + key + "' not found in the map.");
		}
	}

	// Method to check if a Map is empty
	public static void checkIfMapIsEmpty(Map<String, Integer> map) {
		if (map.isEmpty()) {
			System.out.println("The map is empty.");
			
		} else {
			System.out.println("The map is not empty.");
		}
	}

	// Method to clear a Map (remove all entries)
	public static void clearMap(Map<String, Integer> map) {
		map.clear();
		
		System.out.println("Map cleared.");
	}

	// Method to demonstrate using forEach on a Map
	public static void forEachExample(Map<String, Integer> map) {
		System.out.println("Using forEach on the Map:");
		
		map.forEach((key, value) -> System.out.println(key + ": " + value));
	}

	// Method to get the key set of a Map
	public static void getKeySet(Map<String, Integer> map) {
		System.out.println("Key Set: " + map.keySet());
	}

	// Method to get the value collection of a Map
	public static void getValueCollection(Map<String, Integer> map) {
		System.out.println("Value Collection: " + map.values());
	}

	// Method to get keys and values from a Map
	public static void getKeysAndValues(Map<String, Integer> map) {
		System.out.println("Keys and Values:");
		
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
	}

	// Method to add all entries from one map to another
	public static void addAllEntriesFromMap(Map<String, Integer> destinationMap, Map<String, Integer> sourceMap) {
		destinationMap.putAll(sourceMap);
		
		System.out.println("Added all entries from source map to destination map.");
	}

	// Method to remove all entries in one map that are also in another map
	public static void removeAllEntriesInCommon(Map<String, Integer> map1, Map<String, Integer> map2) {
		map1.entrySet().removeIf(entry -> map2.containsKey(entry.getKey()));
		
		System.out.println("Removed all entries in common between the two maps.");
	}
}
