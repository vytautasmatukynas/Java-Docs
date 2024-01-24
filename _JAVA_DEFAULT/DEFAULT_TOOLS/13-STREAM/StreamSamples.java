import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamSamples {

	public static void main(String[] args) {

		// Sample 0: Filtering non-null elements and converting to uppercase (using Optional)
		List<String> names = Arrays.asList("Alice", "Bob", null, "Charlie", null, "David");
		List<String> nonNull = names.stream()
				.map(Optional::ofNullable) // Wrap each element with an Optional
				.filter(Optional::isPresent) // Filter out empty OPTIONALS (null values)
				.map(Optional::get) // Unwrap the values from the OPTIONALS
				.map(String::toUpperCase) // Convert to UPPERCASE or do ANYTHING ELSE
				.toList();
		nonNull.forEach(System.out::println);

		// Sample 1: Filtering non-null elements and converting to uppercase
		List<String> names1 = Arrays.asList("Alice", "Bob", null, "Charlie", null, "David");
		List<String> nonNullList1 = names1.stream()
				.filter(Objects::nonNull)         // Keep only non-null elements
				.map(String::toUpperCase)        // Convert each element to uppercase
				.collect(Collectors.toList());   // Collect the results into a List
		System.out.println(nonNullList1);

		// Sample 2: Filtering distinct elements and converting to lowercase
		List<String> names2 = Arrays.asList("Alice", "Bob", "Alice", "Charlie", "Bob", "David");
		Set<String> distinctSet = names2.stream()
				.distinct()                      // Keep only distinct elements
				.map(String::toLowerCase)        // Convert each element to lowercase
				.collect(Collectors.toSet());    // Collect the results into a Set
		System.out.println(distinctSet);

		// Sample 3: Mapping and joining elements into a single string
		List<String> names3 = Arrays.asList("Alice", "Bob", "Charlie", "David");
		String concatenatedString = names3.stream()
				.map(String::toUpperCase)        // Convert each element to uppercase
				.collect(Collectors.joining(", ")); // Concatenate and join the elements with a comma
		System.out.println(concatenatedString);

		// Sample 4: Filtering and counting the number of elements
		List<String> names4 = Arrays.asList("Alice", "Bob", null, "Charlie", null, "David");
		long countNonNull = names4.stream()
				.filter(Objects::nonNull)         // Keep only non-null elements
				.count();                        // Count the number of elements
		System.out.println("Count of non-null elements: " + countNonNull);

		// Sample 5: Mapping to lengths and finding the maximum length
		List<String> names5 = Arrays.asList("Alice", "Bob", "Charlie", "David");
		OptionalInt maxLength = names5.stream()
				.mapToInt(String::length)        // Map to IntStream of string lengths
				.max();                          // Find the maximum length
		System.out.println("Maximum length: " + (maxLength.isPresent() ? maxLength.getAsInt() : "N/A"));

		// Sample 6: Filtering and collecting to a Map
		List<String> names6 = Arrays.asList("Alice", "Bob", "Charlie", "David");
		Map<Integer, List<String>> lengthToNamesMap = names6.stream()
				.collect(Collectors.groupingBy(String::length)); // Group elements by their length
		System.out.println(lengthToNamesMap);

		// Sample 7: Mapping and reducing to a single concatenated string
		List<String> names7 = Arrays.asList("Alice", "Bob", "Charlie", "David");
		String concatenatedNames = names7.stream()
				.map(String::toUpperCase)        // Convert each element to uppercase
				.reduce("", (s1, s2) -> s1 + s2); // Concatenate the elements
		System.out.println(concatenatedNames);

		// Sample 8: Filtering and collecting to an Optional
		List<String> names8 = Arrays.asList("Alice", "Bob", null, "Charlie", null, "David");
		Optional<String> firstNonNull = names8.stream()
				.filter(Objects::nonNull)         // Keep only non-null elements
				.findFirst();                    // Find the first non-null element
		System.out.println("First non-null element: " + firstNonNull.orElse("N/A"));

		// Sample 9: Mapping and converting to an array
		List<String> names9 = Arrays.asList("Alice", "Bob", "Charlie", "David");
		String[] nameArray = names9.stream()
				.map(String::toUpperCase)        // Convert each element to uppercase
				.toArray(String[]::new);         // Convert the stream to an array
		System.out.println(Arrays.toString(nameArray));

		// Sample 10: Mapping and collecting to a LinkedList
		List<String> names10 = Arrays.asList("Alice", "Bob", "Charlie", "David");
		LinkedList<String> linkedList = names10.stream()
				.map(String::toUpperCase)        // Convert each element to uppercase
				.collect(Collectors.toCollection(LinkedList::new)); // Collect into a LinkedList
		System.out.println(linkedList);

		// Sample 11: Filtering and collecting to a TreeSet
		List<String> names11 = Arrays.asList("Alice", "Bob", "Charlie", "David");
		TreeSet<String> treeSet = names11.stream()
				.filter(s -> s.length() > 3)    // Keep only elements with length greater than 3
				.collect(Collectors.toCollection(TreeSet::new)); // Collect into a TreeSet
		System.out.println(treeSet);

		// Sample 12: Mapping and summing the lengths
		List<String> names12 = Arrays.asList("Alice", "Bob", "Charlie", "David");
		int totalLength = names12.stream()
				.mapToInt(String::length)        // Map to IntStream of string lengths
				.sum();                          // Sum the lengths
		System.out.println("Total length of all names: " + totalLength);

		// Sample 13: Filtering and converting to a HashSet
		List<String> names13 = Arrays.asList("Alice", "Bob", "Charlie", "David");
		Set<String> nameSet = names13.stream()
				.filter(s -> s.length() > 3)    // Keep only elements with length greater than 3
				.collect(Collectors.toSet());    // Collect into a HashSet
		System.out.println(nameSet);

		// Sample 14: Mapping and checking if any element starts with 'A'
		List<String> names14 = Arrays.asList("Alice", "Bob", "Charlie", "David");
		boolean anyStartsWithA = names14.stream()
				.anyMatch(s -> s.startsWith("A")); // Check if any element starts with 'A'
		System.out.println("Any name starts with 'A': " + anyStartsWithA);

		// Sample 15: Mapping and collecting to an unmodifiable List
		List<String> names15 = Arrays.asList("Alice", "Bob", "Charlie", "David");
		List<String> unmodifiableList = names15.stream()
				.map(String::toUpperCase)        // Convert each element to uppercase
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList)); // Collect into an unmodifiable List
		System.out.println(unmodifiableList);

		// Sample 16: Filtering and collecting to a concurrent list
		List<String> names16 = Arrays.asList("Alice", "Bob", "Charlie", "David");
		List<String> concurrentList = names16.parallelStream()
				.filter(s -> s.length() > 4)    // Keep only elements with length greater than 4
				.collect(Collectors.toList());   // Collect into a concurrent List
		System.out.println(concurrentList);

		// Sample 17: Mapping and collecting to a concurrent set
		List<String> names17 = Arrays.asList("Alice", "Bob", "Charlie", "David");
		Set<String> concurrentSet = names17.parallelStream()
				.map(String::toLowerCase)        // Convert each element to lowercase
				.collect(Collectors.toSet());    // Collect into a concurrent Set
		System.out.println(concurrentSet);

		// Sample 18: Filtering and mapping to an IntStream
		List<String> names18 = Arrays.asList("Alice", "Bob", "Charlie", "David");
		IntStream nameLengths = names18.stream()
				.filter(Objects::nonNull)         // Keep only non-null elements
				.mapToInt(String::length);        // Map to IntStream of string lengths
		nameLengths.forEach(System.out::println); // Print each length

		// Sample 19: Mapping and reducing to an Optional
		List<String> names20 = Arrays.asList("Alice", "Bob", null, "Charlie", null, "David");
		Optional<String> concatenatedOptional = names20.stream()
				.filter(Objects::nonNull)         // Keep only non-null elements
				.reduce((s1, s2) -> s1 + s2);     // Concatenate the elements
		System.out.println("Concatenated string: " + concatenatedOptional.orElse("N/A"));

		// Sample 20: Mapping and summing elements
		int[] numbers1 = {1, 2, 3, 4, 5};
		int sum1 = Arrays.stream(numbers1)
				.sum(); // Sum all elements
		System.out.println("Sum of elements: " + sum1);

		// Sample 21: Mapping and finding the average
		int[] numbers2 = {1, 2, 3, 4, 5};
		OptionalDouble average2 = Arrays.stream(numbers2)
				.average(); // Calculate the average
		System.out.println("Average: " + (average2.isPresent() ? average2.getAsDouble() : "N/A"));

		// Sample 22: Filtering and counting elements
		int[] numbers3 = {1, 2, 3, 4, 5};
		long count3 = Arrays.stream(numbers3)
				.filter(n -> n % 2 == 0) // Keep only even numbers
				.count(); // Count the number of elements
		System.out.println("Count of even numbers: " + count3);

		// Sample 23: Mapping and converting to an array
		int[] numbers4 = {1, 2, 3, 4, 5};
		int[] squaredArray = Arrays.stream(numbers4)
				.map(n -> n * n) // Square each element
				.toArray(); // Convert the stream to an array
		System.out.println(Arrays.toString(squaredArray));

		// Sample 24: Filtering and mapping to another array
		int[] numbers5 = {1, 2, 3, 4, 5};
		int[] doubledArray = Arrays.stream(numbers5)
				.filter(n -> n % 2 != 0) // Keep only odd numbers
				.map(n -> n * 2) // Double each odd number
				.toArray(); // Convert the stream to an array
		System.out.println(Arrays.toString(doubledArray));

		// Sample 25: Filtering and summing even numbers
		int[] numbers6 = {1, 2, 3, 4, 5};
		int sumEven = Arrays.stream(numbers6)
				.filter(n -> n % 2 == 0) // Keep only even numbers
				.sum(); // Sum the even numbers
		System.out.println("Sum of even numbers: " + sumEven);

		// Sample 26: Mapping and checking if all elements are greater than 0
		int[] numbers7 = {1, 2, 3, 4, 5};
		boolean allGreaterThanZero = Arrays.stream(numbers7)
				.allMatch(n -> n > 0); // Check if all elements are greater than 0
		System.out.println("All elements greater than 0: " + allGreaterThanZero);

		// Sample 27: Filtering and finding the maximum value
		int[] numbers8 = {1, 2, 3, 4, 5};
		OptionalInt max8 = Arrays.stream(numbers8)
				.filter(n -> n % 2 != 0) // Keep only odd numbers
				.max(); // Find the maximum odd number
		System.out.println("Maximum odd number: " + (max8.isPresent() ? max8.getAsInt() : "N/A"));

		// Sample 28: Mapping and reducing to calculate the product
		int[] numbers9 = {1, 2, 3, 4, 5};
		int product9 = Arrays.stream(numbers9)
				.reduce(1, (a, b) -> a * b); // Calculate the product of all elements
		System.out.println("Product of elements: " + product9);

		// Sample 29: Filtering and checking if any element is greater than 5
		int[] numbers10 = {1, 2, 3, 4, 5};
		boolean anyGreaterThanFive = Arrays.stream(numbers10)
				.anyMatch(n -> n > 5); // Check if any element is greater than 5
		System.out.println("Any element greater than 5: " + anyGreaterThanFive);

		// Sample 30: Mapping and converting to a String
		int[] numbers11 = {1, 2, 3, 4, 5};
		String concatenatedString1 = Arrays.stream(numbers11)
				.mapToObj(String::valueOf) // Convert each element to String
				.reduce("", (s1, s2) -> s1 + s2); // Concatenate the Strings
		System.out.println("Concatenated string: " + concatenatedString1);

	}

}
