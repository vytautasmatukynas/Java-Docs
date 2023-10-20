import java.util.*;

public class MapTypesAndChangeType {
    public static void main(String[] args) {
        // HashMap to LinkedHashMap
        // HashMap: An unordered map that stores key-value pairs.
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("banana", 2);
        hashMap.put("apple", 1);
        hashMap.put("cherry", 3);
        
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
        
        // Convert HashMap to LinkedHashMap (Preserves insertion order)
        // LinkedHashMap: A map that preserves the order of key-value pairs.
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(hashMap);
        
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();

        // LinkedHashMap to TreeMap
        // Convert LinkedHashMap to TreeMap (Sorts keys in natural order)
        // TreeMap: A map that stores key-value pairs sorted by keys.
        Map<String, Integer> treeMap = new TreeMap<>(linkedHashMap);

        // Iterating through the TreeMap (keys are in sorted order)
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
