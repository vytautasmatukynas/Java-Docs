package tool.random.projects;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * T: Stands for "Type" and is often used as a generic type parameter for
 * general purposes when the type doesn't need to have a specific meaning. For
 * example, in a generic class like Box<T>, T can represent any data type.
 * 
 * K / V: Commonly used to represent keys in key-value pairs or maps. For
 * example, in Map<K, V>, K represents the type of keys, and V represents the
 * type of values.
 * 
 * <?> is a WILDCARD type that represents an unknown type. It can be used in
 * generic classes, methods, or as a type for variables when you want to
 * indicate that the exact type is not known or doesn't matter in a particular
 * context. <?> is often referred to as an "unbounded WILDCARD."
 * 
 * In this sample - method "print" can take in any type of Collection or Array
 * and print it.
 */

public class App {

	public static void main(String[] args) {

		Integer[] intArray = { 1, 2, 3 };
		String[] stringArray = { "rr", "tt" };

		List<String> list = List.of("AA", "BB", "AA", "BB");
		Set<Long> set = Set.of(5L, 8L, 15L);
		Map<Integer, String> map = Map.of(1, "BB", 2, "BB");

		print(intArray);
		print(stringArray);

		print(list);
		print(set);
		print(map);

	}

	static <T> void print(T[] arr) {
		Arrays.stream(arr).forEach(System.out::println);
	}

	public static void print(Collection<?> collection) {
		collection.forEach(System.out::println);
	}

	public static void print(Map<?, ?> collection) {
		collection.forEach((K, V) -> System.out.println(K + ": " + V));
	}

}
