import java.util.*;

public class SetTypesAndChangeType {
    public static void main(String[] args) {
        // HashSet to LinkedHashSet
        // HashSet: An unordered set that does not allow duplicates.
        Set<String> hashSet = new HashSet<>();
        hashSet.add("banana");
        hashSet.add("apple");
        hashSet.add("cherry");
        
        // Convert HashSet to LinkedHashSet (Preserves insertion order)
        // LinkedHashSet: A set that preserves the order of insertion.
        Set<String> linkedHashSet = new LinkedHashSet<>(hashSet);

        // LinkedHashSet to TreeSet
        // Convert LinkedHashSet to TreeSet (Sorts elements in natural order)
        // TreeSet: A set that stores elements in sorted (natural or custom) order.
        Set<String> treeSet = new TreeSet<>(linkedHashSet);

        // Iterating through the TreeSet (elements are in sorted order)
        for (String fruit : treeSet) {
            System.out.println(fruit);
        }
    }
}
