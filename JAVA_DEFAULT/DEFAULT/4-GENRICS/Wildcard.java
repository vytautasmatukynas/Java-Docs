import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <?> is a WILDCARD type that represents an unknown type. It can be used in
 * generic classes, methods, or as a type for variables when you want to
 * indicate that the exact type is not known or doesn't matter in a particular
 * context. <?> is often referred to as an "unbounded WILDCARD."
 * 
 * In this sample method "print" can take in any type of Collection or Array and
 * print it.
 */

public class Wildcard {

	public static void main(String[] args) {

		List<String> list = List.of("AA", "BB", "AA", "BB");
		Set<String> set = Set.of("AA", "BB", "CC");
		Map<Integer, String> map = Map.of(1, "BB", 2, "BB");

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
