
public class Emplo extends Person{

	String poz;

	public Emplo(String name, int age, String poz) {
		super(name, age);
		this.poz = poz;
		System.out.println("EMPLO CONST");
	}
	
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Pozicija: " + poz);
		
		System.out.println();
		
		super.displayInfo(" | Pozicija: " + poz);
	}

}
