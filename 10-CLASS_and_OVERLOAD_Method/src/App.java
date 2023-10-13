
public class App {

	public static void main(String[] args) {

		// create array object from class Automobilis
		Automobilis[] masinos = new Automobilis[2];

		// add items to array
		masinos[0] = new Automobilis(1902, "Audi");
		masinos[1] = new Automobilis(1800, "OPEL");

		for (Automobilis auto : masinos)
			System.out.println(auto.getModelis() + " - " + auto.getMetai());

		Person p1 = new Person("Petras", "Petrauskas", 20);
		System.out.println(p1.getVisasVardas());
		p1.check(5);
		p1.check("Jonas");

	}

}
