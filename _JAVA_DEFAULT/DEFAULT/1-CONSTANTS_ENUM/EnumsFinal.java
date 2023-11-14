//ENUM CAN BE FINAL, LIKE ALWAYS CONSTANT
public enum EnumsFinal {

	// create ENUM objects and sign values to it
	DEFAULT("\u001B[0m" + "BALTA"), 
	RED("\u001B[31m" + "RAUDONA");

	private final String spalva;

	EnumsFinal(String sp) {
		spalva = sp;
	}

	public String getSpalva() {
		return spalva;
	}

}