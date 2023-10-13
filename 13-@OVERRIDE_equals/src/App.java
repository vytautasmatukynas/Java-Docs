
public class App {

	public static void main(String[] args) {
		DefaultClass obj1 = new DefaultClass(1, "John");
		DefaultClass obj2 = new DefaultClass(1, "John");

		if (obj1.equals(obj2)) {
		    System.out.println("obj1 and obj2 are equal.");
		} else {
		    System.out.println("obj1 and obj2 are not equal.");
		}

	}

}
