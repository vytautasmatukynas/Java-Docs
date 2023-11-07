import java.util.LinkedList;
import java.util.Queue;

/*
The Queue interface is present in java.util package and extends the Collection interface is used to hold
the elements about to be processed in FIFO(First In First Out) order. It is an ordered list of objects with
its use limited to inserting elements at the end of the list and deleting elements from the start of the list,
(i.e.), it follows the FIFO or the First-In-First-Out principle
 */
public class QueueClass {

    public static void main(String[] args) {
        // Create a queue using a LinkedList
        Queue<String> queue = new LinkedList<>();

        // Add elements to the queue (enqueue)
        queue.add("Apple");
        queue.add("Banana");
        queue.offer("Cherry");

        // Print the queue
        System.out.println("Queue: " + queue);

        // Peek at the front element without removing it
        String front = queue.peek();
        System.out.println("Front element: " + front);

        // Remove and retrieve the front element (dequeue)
        String removed = queue.poll();
        System.out.println("Removed front element: " + removed);

        // Check if the queue is empty
        boolean isEmpty = queue.isEmpty();
        System.out.println("Is the queue empty? " + isEmpty);

        // Get the size of the queue
        int size = queue.size();
        System.out.println("Queue size: " + size);

        // Clear the queue
        queue.clear();
        System.out.println("Queue after clearing: " + queue);

        // Add elements to the empty queue
        queue.add("Grapes");
        queue.add("Orange");
        System.out.println("Queue after adding more elements: " + queue);

        // Check if the queue contains an element
        boolean containsBanana = queue.contains("Banana");
        System.out.println("Does the queue contain 'Banana'? " + containsBanana);

        // Additional Queue methods:

        // Add elements to the queue (enqueue)
        queue.add("Strawberry");
        queue.add("Mango");

        // Peek at the front element without removing it
        front = queue.peek();
        System.out.println("Front element: " + front);

        // Remove and retrieve the front element (dequeue)
        removed = queue.poll();
        System.out.println("Removed front element: " + removed);

        // Check if the queue is empty
        isEmpty = queue.isEmpty();
        System.out.println("Is the queue empty? " + isEmpty);

        // Get the size of the queue
        size = queue.size();
        System.out.println("Queue size: " + size);
    }

}
