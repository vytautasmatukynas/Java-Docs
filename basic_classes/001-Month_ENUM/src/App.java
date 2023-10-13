import java.time.LocalDate;
import java.time.Month;

public class App {

	public static void main(String[] args) {

		LocalDate data = LocalDate.now();

		String menesis = getMenesis(data.getMonth());
		System.out.println(menesis);

	}

	public static String getMenesis(Month month) {
		switch (month) {
		case JANUARY:
			return "Sausis";
		case FEBRUARY:
			return "Vasaris";
		case MARCH:
			return "Kovas";
		case APRIL:
			return "Balandis";
		case JUNE:
			return "Birzelis";
		case JULY:
			return "Liepa";
		case AUGUST:
			return "Rugpjutis";
		case SEPTEMBER:
			return "Rugsejis";
		case OCTOBER:
			return "Spalis";
		case NOVEMBER:
			return "Lapkritis";
		case DECEMBER:
			return "Gruodis";
		default:
			return "";
		}

	}

}
