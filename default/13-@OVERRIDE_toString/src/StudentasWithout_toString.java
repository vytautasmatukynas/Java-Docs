
public class StudentasWithout_toString {

	String vardas;
	String pavarde;

	public StudentasWithout_toString(String vardas, String pavarde) {
		this.vardas = vardas;
		this.pavarde = pavarde;
	}

	public String getVardas() {
		return vardas;
	}

	public void setVardas(String vardas) {
		this.vardas = vardas;
	}

	public String getPavarde() {
		return pavarde;
	}

	public void setPavarde(String pavarde) {
		this.pavarde = pavarde;
	}

	public String getFullName() {
		return vardas + " " + pavarde;
	}

}
