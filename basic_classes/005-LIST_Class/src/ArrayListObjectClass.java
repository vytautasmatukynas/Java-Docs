import java.util.ArrayList;

public class ArrayListObjectClass {

	private ArrayList<String> listA = new ArrayList<String>();

	public void add(String name) {
		listA.add(name);
	}

	public void add(int index, String name) {
		listA.add(index, name);
	}

	public void print() {
		for (String item : listA) {
			System.out.println(item);
		}

	}
}
