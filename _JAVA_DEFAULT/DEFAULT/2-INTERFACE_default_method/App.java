/**
 * Interface can have method body.
 * But if you implement from 2 interfaces in both have same method name, you have to 
 * override it and use super to use it
 */


public class App {

	public static void main(String[] args) {
		MainClass mainClass = new MainClass();
		mainClass.display();

	}

}

class MainClass implements InterfaceA, InterfaceB {
	@Override
	public void display() {
		InterfaceB.super.display();
		InterfaceA.super.display();
	}
}

interface InterfaceA {
	default void display() {
		System.out.println("Hello from InterfaceA");
	}
}

interface InterfaceB {
	default void display() {
		System.out.println("Hello from InterfaceB");
	}
}
