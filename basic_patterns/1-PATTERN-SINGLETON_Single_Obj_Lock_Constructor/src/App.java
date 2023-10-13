/**
 * SINGLE OBJECT
 */

public class App {

	public static void main(String[] args) {
		
		SingletonSample singleton = SingletonSample.getInstance();
		SingletonSample singleton2 = SingletonSample.getInstance();
		SingletonSample singleton3 = SingletonSample.getInstance();

		singleton.add("oooo");
		singleton2.add("uuuu");
		singleton3.add("aaaa");
		
		singleton.print();
		singleton2.print();
		singleton3.print();
		
}

}
