
public class Automobilis {

	int metai;
	String modelis;

	public Automobilis(int metai, String modelis) {
		setMetai(metai);
		this.modelis = modelis;
	}

	// check if year is valid
	public void setMetai(int metai) {
		if (metai < 1900) {
			System.err.println("Enter valid year");
			return;
		} else {
			this.metai = metai;
		}
	}

	public int getMetai() {
		return metai;
	}

	public String getModelis() {
		return modelis;
	}

}
