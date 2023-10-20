
public class App {

	public static void main(String[] args) {
		
        MyClass original = new MyClass(42);

        try {
            MyClass cloned = (MyClass) original.clone();

            System.out.println("Original: " + original.getValue());
            System.out.println("Cloned: " + cloned.getValue());

            // Modifying the cloned object's value
            cloned.setValue(100);

            System.out.println("Original: " + original.getValue());
            System.out.println("Cloned: " + cloned.getValue());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

	}

}
