import java.util.*;

public class ListTypesAndChangeTypes {
    public static void main(String[] args) {
        // ArrayList to LinkedList
        // ArrayList: A dynamic array that allows efficient random access.
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        // Convert ArrayList to LinkedList (Allows efficient insertions/deletions)
        // LinkedList: A doubly-linked list that allows efficient insertions/deletions.
        List<Integer> linkedList = new LinkedList<>(arrayList);

        // Iterating through the ArrayList
        for (int number : arrayList) {
            System.out.println(number);
        }
        
        // Iterating through the ArrayList
        for (int number : linkedList) {
            System.out.println(number);
        }
    }
}
