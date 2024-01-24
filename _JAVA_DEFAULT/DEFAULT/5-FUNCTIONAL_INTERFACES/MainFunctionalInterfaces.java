import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class MainFunctionalInterfaces {

    public static void main(String[] args) {

        // Consumer<T>: Accepts a single argument and performs an action, no result returned.
        Consumer<String> printUpperCase = str -> System.out.println("Print Uppercase: " + str.toUpperCase());
        printUpperCase.accept("hello");

        // Supplier<T>: Provides a result, takes no input arguments.
        Supplier<Double> getRandomDouble = () -> Math.random() * 100;
        System.out.println("Random double: " + getRandomDouble.get());

        // Function<T, R>: Accepts an argument, performs a transformation, and produces a result.
        Function<Integer, String> convertToString = num -> "Number as String: " + num;
        System.out.println(convertToString.apply(42));

        // Predicate<T>: Tests a condition on a single argument and returns a boolean result.
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10));

        // UnaryOperator<T>: Represents a unary operation (single argument) producing a result of the same type.
        UnaryOperator<Integer> square = num -> num * num;
        System.out.println("Square of 5: " + square.apply(5));

        // BinaryOperator<T>: Represents a binary operation (two arguments) producing a result of the same type.
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println("Product of 5 and 6: " + multiply.apply(5, 6));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Consumer<T>: Accepts a single argument and performs an action, no result returned.
        forEachWithConsumer(numbers);

        // Supplier<T>: Provides a result, takes no input arguments.
        generateRandomDoubles();

        // Function<T, R>: Accepts an argument, performs a transformation, and produces a result.
        mapWithFunction(numbers);

        // Predicate<T>: Tests a condition on a single argument and returns a boolean result.
        filterWithPredicate(numbers);

        // UnaryOperator<T>: Represents a unary operation (single argument) producing a result of the same type.
        mapWithUnaryOperator(numbers);

        // BinaryOperator<T>: Represents a binary operation (two arguments) producing a result of the same type.
        reduceWithBinaryOperator(numbers);
    }

    // Consumer<T>
    // Explanation: forEachWithConsumer takes a List<Integer> and uses the Consumer interface to print each element in the list.
    private static void forEachWithConsumer(List<Integer> numbers) {
        System.out.print("ForEach with Consumer: ");
        numbers.forEach(num -> System.out.print(num + " "));
        System.out.println();
    }

    // Supplier<T>
    // Explanation: generateRandomDoubles uses the Supplier interface to create a stream of random doubles and prints the first 5.
    private static void generateRandomDoubles() {
        System.out.println("Generate Random Doubles: ");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    // Function<T, R>
    // Explanation: mapWithFunction uses the Function interface to convert each number in the list to a string with a specific format.
    private static void mapWithFunction(List<Integer> numbers) {
        System.out.print("Map with Function: ");
        numbers.stream()
                .map(num -> "Number as String: " + num)
                .forEach(System.out::println);
    }

    // Predicate<T>
    // Explanation: filterWithPredicate uses the Predicate interface to filter and print only the even numbers from the list.
    private static void filterWithPredicate(List<Integer> numbers) {
        System.out.print("Filter with Predicate: ");
        numbers.stream()
                .filter(num -> num % 2 == 0)
                .forEach(num -> System.out.print(num + " "));
        System.out.println();
    }

    // UnaryOperator<T>
    // Explanation: mapWithUnaryOperator uses the UnaryOperator interface to square each number in the list and print the results.
    private static void mapWithUnaryOperator(List<Integer> numbers) {
        System.out.print("Map with UnaryOperator (Square): ");
        numbers.stream()
                .map(num -> num * num)
                .forEach(num -> System.out.print(num + " "));
        System.out.println();
    }

    // BinaryOperator<T>
    // Explanation: reduceWithBinaryOperator uses the BinaryOperator interface to calculate the product of all numbers in the list.
    private static void reduceWithBinaryOperator(List<Integer> numbers) {
        int product = numbers.stream()
                .reduce((a, b) -> a * b)
                .orElse(0);
        System.out.println("Reduce with BinaryOperator (Product): " + product);
    }

}
