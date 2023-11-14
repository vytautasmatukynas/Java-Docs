// YOU CAN PLAY WIIH ENUM VALUE IN PROCCESS
// IF 'number = 1' prints "RAUDONA" if 'number' something else prints "JUODA"
public enum Enums {
	// create ENUM objects and sign values to it
	DEFAULT("\u001B[0m" + "BALTA");

	private String spalva;

	Enums(String sp) {
		spalva = sp;
	}

	public String getSpalva() {
		int number = 1;
		if (number == 2)
			return spalva;
		else
			return spalva = "\u001B[31m" + "RAUDONA";

	}

}