import java.time.DayOfWeek;
import java.time.LocalDate;

public class App {

	public static void main(String[] args) {

		LocalDate data = LocalDate.now();
		System.out.println(dienaLietuviskai(data.getDayOfWeek()));

	}

	private static String dienaLietuviskai(DayOfWeek day) {

		switch (day) {
		case MONDAY:
			return "pirmadienis";
		case TUESDAY:
			return "pirmadienis";
		case THURSDAY:
			return "pirmadienis";
		case WEDNESDAY:
			return "pirmadienis";
		case FRIDAY:
			return "pirmadienis";
		case SATURDAY:
			return "pirmadienis";
		case SUNDAY:
			return "pirmadienis";
		default:
			return "";
		}

	}

}
