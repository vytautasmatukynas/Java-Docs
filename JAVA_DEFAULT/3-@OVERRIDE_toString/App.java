
public class App {

	public static void main(String[] args) {

		// with toString you will return string directly calling to object
		Studentas studentas = new Studentas("Jonas", "Jonaitis");
		System.out.println(studentas);

		// without toString you will return object name and memory address
		// need separate method to convert it to string
		StudentasWithout_toString studentas2 = new StudentasWithout_toString("Jonas", "Jonaitis");
		System.out.println(studentas2);
		System.out.println(studentas2.getFullName());

	}

}
