
public class Person {

	private String vardas;
	private String pavarde;
	private int metai;

	public Person(String vardas, String pavarde, int metai) {
		System.out.println("Kuriamas vardas ir pavarde");
		System.out.println("Vardas: " + vardas + "\n" + "Pavarde: " + pavarde);
		this.vardas = vardas;
		this.pavarde = pavarde;
		this.metai = metai;
	}

	public String getVisasVardas() {
		return vardas + " " + pavarde + " " + metai;
	}

	// over-load method with different parameter types
	public void check(String vardas) {
		this.vardas = vardas;
		System.out.println("Vardas: " + this.vardas);
	}

	public void check(int metai) {
		this.metai = metai;
		System.out.println("Metai: " + this.metai);
	}

}
