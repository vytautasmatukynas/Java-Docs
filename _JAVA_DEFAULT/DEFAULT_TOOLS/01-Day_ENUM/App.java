import java.time.DayOfWeek;
import java.time.LocalDate;

public class App {

	public static void main(String[] args) {

		LocalDate data = LocalDate.now();
		System.out.println(dienaLietuviskai(data.getDayOfWeek()));

	}

	private static String dienaLietuviskai(DayOfWeek day) {

        return switch (day) {
            case MONDAY -> "pirmadienis";
            case TUESDAY -> "pirmadienis";
            case THURSDAY -> "pirmadienis";
            case WEDNESDAY -> "pirmadienis";
            case FRIDAY -> "pirmadienis";
            case SATURDAY -> "pirmadienis";
            case SUNDAY -> "pirmadienis";
			default -> "";
        };

	}

}
