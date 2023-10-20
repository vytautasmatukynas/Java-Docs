
public class App {

	public static void main(String[] args) {

		// value object saved in memory
		int a = 5;
		// create new value object in memory that Inherit value from a
		int b = a;

		System.out.println(a + " " + b);

		// adds +10 just to b because it's new object i memory
		b += 10;

		System.out.println(a + " " + b);

		// create new reference to object in memory
		Box box1 = new Box();
		System.out.println(box1);

		// assign value to it
		box1.setLength(5);

		Box box2 = box1;
		System.out.println(box2);

		System.out.println(box1.getLength() + " " + box2.getLength());

		box2.length += 10;

		System.out.println(box1.getLength() + " " + box2.getLength());
	}

}
