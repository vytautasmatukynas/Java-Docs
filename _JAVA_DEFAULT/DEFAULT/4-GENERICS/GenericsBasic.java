import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * T: Stands for "Type" and is often used as a generic type parameter for
 * general purposes when the type doesn't need to have a specific meaning. For
 * example, in a generic class like Box<T>, T can represent any data type.
 * 
 * E: Stands for "Element" and is often used for elements in a collection or
 * container classes. For instance, in List<E> or Set<E>, E represents the type
 * of elements stored in the collection.
 * 
 * K / V: Commonly used to represent keys in key-value pairs or maps. For
 * example, in Map<K, V>, K represents the type of keys, and V represents the
 * type of values.
 * 
 * N: Sometimes used to represent a number, especially when working with numeric
 * data types. For example, in a generic class like NumberWrapper<N extends
 * Number>, N would represent a numeric type.
 */

public class GenericsBasic {

	public static void main(String[] args) {

		Integer[] skaiciai = { 1, 2, 3 };
		String[] raides = { "a", "b" };

		print(skaiciai);
		print(raides);

		Item<String> item = new Item<String>("Zodis");
		Item<Integer> item2 = new Item<Integer>(5);
		Item<Float> item3 = new Item<Float>(5.5f);

		System.out.println(item.getElement() + ", " + item2.getElement() + ", " + item3.getElement());
		
		List<String> list = createList();
		
		list.add("OO");
		list.add("OO");
		list.add("OO");
		
		list.forEach(System.out::println);
		
	}

	/*
	 * GENERIC Method
	 */
	static <T> void print(T[] arr) {
		Arrays.stream(arr).forEach(System.out::println);
	}
	
	/*
	 * GENERIC Method returning GENERIC Type
	 */
	static <T> List<T> createList () {
		List<T> list = new ArrayList<>();
		return list;
	}

}

/*
 * GENERIC Class
 */
class Item<T> {

	T element;

	public Item(T element) {
		this.element = element;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

}
