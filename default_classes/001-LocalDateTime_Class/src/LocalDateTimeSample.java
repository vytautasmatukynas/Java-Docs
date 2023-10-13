import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.sql.Date;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

public class LocalDateTimeSample {

	public static void main(String[] args) {

		localDateTime();
		localDate();
		localTime();
		formatter();
		get();

		createAndManipulateDateTime();
		formatAndParseDateTime();
		performArithmeticOperations();
		compareDatesAndTimes();
		workWithTimeZonesAndOffsets();
		workWithDurationAndPeriod();
		adjustDateAndTime();
		calculateDuration();
		adjustTimeZone();
		formatAndParseISO8601();

		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list2 = new LinkedList<Integer>();

		timeDiff(list);
		timeDiff(list2);

		timeDiffSystem(list);
		timeDiffSystem(list2);

	}

	private static void timeDiffSystem(List<Integer> list) {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++)
			list.add(i);

		long endTime = System.currentTimeMillis();

		long duration = endTime - startTime;

		System.out.println("Uztruko: " + duration + " ms");
	}

	private static void timeDiff(List<Integer> list) {
		LocalTime timeStart = LocalTime.now();

		for (int i = 0; i < 100000; i++)
			list.add(i);

		LocalTime timeEnd = LocalTime.now();

		System.out.println("Uztruko: " + Duration.between(timeStart, timeEnd).getSeconds() + "." + Duration.between(timeStart, timeEnd).getNano() + " s");
	}

	public static void createAndManipulateDateTime() {
		// Creating Date and Time Objects
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();

		// Manipulating Date and Time
		LocalDateTime newDateTime = dateTime.withYear(2024).withMonth(5).withDayOfMonth(15);
		LocalDateTime modifiedDateTime = dateTime.plusDays(7).minusHours(2);

		System.out.println("Created Date: " + date);
		System.out.println("Created Time: " + time);
		System.out.println("Created DateTime: " + dateTime);
		System.out.println("New DateTime: " + newDateTime);
		System.out.println("Modified DateTime: " + modifiedDateTime);
	}

	public static void formatAndParseDateTime() {
		// Formatting and Parsing
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.now();
		String formattedDateTime = dateTime.format(formatter);
		LocalDateTime parsedDateTime = LocalDateTime.parse("2023-10-04 15:30:00", formatter);

		System.out.println("Formatted DateTime: " + formattedDateTime);
		System.out.println("Parsed DateTime: " + parsedDateTime);
	}

	public static void performArithmeticOperations() {
		// Date and Time Arithmetic
		LocalDate futureDate = LocalDate.now().plusDays(7);
		LocalDate pastDate = LocalDate.now().minusDays(3);

		System.out.println("Future Date: " + futureDate);
		System.out.println("Past Date: " + pastDate);
	}

	public static void compareDatesAndTimes() {
		// Comparing Dates and Times
		LocalDate dateTime = LocalDate.now();
		LocalDate parsedDateTime = LocalDate.of(2014, 8, 15);

		boolean isBefore = dateTime.isBefore(parsedDateTime);
		boolean isAfter = dateTime.isAfter(parsedDateTime);

		System.out.println("Is Before: " + isBefore);
		System.out.println("Is After: " + isAfter);
	}

	public static void workWithTimeZonesAndOffsets() {
		// Time Zones and Offset
		ZoneId newYorkZone = ZoneId.of("America/New_York");
		ZonedDateTime newYorkTime = ZonedDateTime.now(newYorkZone);

		System.out.println("New York Time: " + newYorkTime);
	}

	public static void workWithDurationAndPeriod() {
		// Duration and Period
		Duration duration = Duration.ofHours(2);
		Period period = Period.ofMonths(3);

		System.out.println("Duration: " + duration);
		System.out.println("Period: " + period);
	}

	public static void adjustDateAndTime() {
		// Working with Periods
		LocalDate date = LocalDate.now();
		LocalDate newDate = date.plus(Period.ofMonths(2));

		// Using Adjusters
		LocalDate nextMonday = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

		System.out.println("New Date: " + newDate);
		System.out.println("Next Monday: " + nextMonday);
	}

	public static void calculateDuration() {
		// Calculating Duration
		Instant startInstant = Instant.now();
		Instant endInstant = startInstant.plus(Duration.ofHours(3));
		Duration durationBetween = Duration.between(startInstant, endInstant);

		System.out.println("Duration Between: " + durationBetween);
	}

	public static void adjustTimeZone() {
		// Adjusting for Time Zones
		ZoneId berlinZone = ZoneId.of("Europe/Berlin");
		LocalDateTime dateTime = LocalDateTime.now();
		ZonedDateTime berlinTime = dateTime.atZone(berlinZone);
		ZoneId newYorkZone = ZoneId.of("America/New_York");
		ZonedDateTime newYorkTime = berlinTime.withZoneSameInstant(newYorkZone);

		System.out.println("Berlin Time: " + berlinTime);
		System.out.println("New York Time: " + newYorkTime);
	}

	public static void formatAndParseISO8601() {
		// Formatting and Parsing ISO 8601
		LocalDateTime dateTime = LocalDateTime.now();
		String isoString = dateTime.toString();
		LocalDateTime parsedDateTimeIso = LocalDateTime.parse(isoString);

		System.out.println("ISO 8601 String: " + isoString);
		System.out.println("Parsed ISO 8601 DateTime: " + parsedDateTimeIso);
	}

	private static void get() {
		LocalDateTime datetime = LocalDateTime.now();
		System.out.println(datetime.get(ChronoField.DAY_OF_WEEK));
		System.out.println(datetime.get(ChronoField.DAY_OF_YEAR));
		System.out.println(datetime.get(ChronoField.DAY_OF_MONTH));
		System.out.println(datetime.get(ChronoField.HOUR_OF_DAY));
		System.out.println(datetime.get(ChronoField.MINUTE_OF_DAY));
	}

	private static void formatter() {
		LocalDateTime datetime = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateTime = datetime.format(format);
		System.out.println(formatDateTime);
	}

	private static void localDateTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		int menesioDiena = dateTime.getDayOfMonth();
		int metuDiena = dateTime.getDayOfYear();
		int menesis = dateTime.getMonthValue();
		int metai = dateTime.getDayOfYear();

		System.out.println(dateTime);
		System.out.println(menesioDiena);
		System.out.println(metuDiena);
		System.out.println(menesis);
		// There is ENUM for months 'import java.time.Month;'
		System.out.println(Month.SEPTEMBER);
		System.out.println(metai);
	}

	private static void localDate() {
		LocalDate date = LocalDate.now();
		LocalDate setSpecificDate = LocalDate.of(2023, 8, 28);

		System.out.println(date);
		System.out.println(setSpecificDate);
	}

	private static void localTime() {
		LocalTime time = LocalTime.now();
		LocalTime time2 = LocalTime.of(15, 2);

		System.out.println(time);
		System.out.println(time2);
	}

}
