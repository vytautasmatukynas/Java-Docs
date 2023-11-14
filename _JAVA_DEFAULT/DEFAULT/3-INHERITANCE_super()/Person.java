
public class Person {
	
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("PERSON CONST");
	}
	
	public void displayInfo() {
		System.out.println("Vardas: " + name + " | Amzius: " + age);
	}
	
	public void displayInfo(String value) {
		System.out.println("Vardas: " + name + " | Amzius: " + age + value);
	}
	

}
