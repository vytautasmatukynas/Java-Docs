import java.util.ArrayList;
import java.util.List;

/*
In Java generics, the super keyword is primarily used in the context of wildcards to
specify a lower bound for a type parameter. It allows you to work with objects of a type
that is a superclass of the specified type or the specified type itself.
 */
public class GenericsSuper {
    public static void main(String[] args) {
        // Create a list of numbers (can be Integer, Double, etc.).
        List<? super Number> numbers = new ArrayList<>();

        // Add elements to the list (all elements are superclasses of Number).
        addNumbers(numbers);

        // Display the elements from the list.
        displayNumbers(numbers);
    }

    // Method to add elements to a list of elements that are superclasses of Number.
    public static void addNumbers(List<? super Number> list) {
        list.add(123);
        list.add(7.89);
    }

    // Method to display elements from the list.
    public static void displayNumbers(List<? super Number> list) {
        for (Object item : list) {
            System.out.println("Value: " + item);
        }
    }
}
