import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/*
Deque interface present in java.util package is a subtype of the queue interface. The Deque is related
to the double-ended queue that supports the addition or removal of elements from either end of the data
structure. It can either be used as a queue(first-in-first-out/FIFO) or as a stack(last-in-first-out/LIFO).
Deque is the acronym for double-ended queue.

The Deque (double-ended queue) interface in Java is a subinterface of the Queue interface and extends it
to provide a double-ended queue, which is a queue that allows elements to be added and removed from both ends.
The Deque interface is part of the Java Collections Framework and is used to provide a generic and flexible data
structure that can be used to implement a variety of algorithms and data structures.
 */
public class DequeClass {

    public static void main(String[] args) {
        // Create a deque using ArrayDeque
        Deque<String> deque = new ArrayDeque<>();

        // Add elements to the front and back
        deque.addFirst("First");
        deque.offerLast("Last");

        // Remove and return elements from the front and back
        String frontElement = deque.pollFirst();
        String backElement = deque.removeLast();

        // Access elements without removing them
        String firstElement = deque.getFirst();
        String lastElement = deque.getLast();

        // Check the size and empty status of the deque
        int size = deque.size();
        boolean isEmpty = deque.isEmpty();

        // More methods:

        // Add an element to the back
        deque.add("New Element");

        // Add an element to the front
        deque.push("Front Element");

        // Remove an element (first occurrence)
        deque.remove("ElementToRemove");

        // Remove the first occurrence of a specific element
        deque.removeFirstOccurrence("FirstOccurrence");

        // Remove the last occurrence of a specific element
        deque.removeLastOccurrence("LastOccurrence");

        // Access the first element without removal
        String element = deque.element();

        // Clear the deque (remove all elements)
        deque.clear();

        // Create an iterator to iterate over the elements
        Iterator<String> iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Create a descending iterator to iterate in reverse order
        Iterator<String> descendingIterator = deque.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.println(descendingIterator.next());
        }
    }
}
