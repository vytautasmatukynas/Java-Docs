import java.time.LocalDate;
import java.time.Month;

public class App {

	public static void main(String[] args) {

		LocalDate data = LocalDate.now();

		String menesis = getMenesis(data.getMonth());
		System.out.println(menesis);

	}

	public static String getMenesis(Month month) {
        return switch (month) {
            case JANUARY -> "Sausis";
            case FEBRUARY -> "Vasaris";
            case MARCH -> "Kovas";
            case APRIL -> "Balandis";
            case JUNE -> "Birzelis";
            case JULY -> "Liepa";
            case AUGUST -> "Rugpjutis";
            case SEPTEMBER -> "Rugsejis";
            case OCTOBER -> "Spalis";
            case NOVEMBER -> "Lapkritis";
            case DECEMBER -> "Gruodis";
            default -> "";
        };

	}

}
