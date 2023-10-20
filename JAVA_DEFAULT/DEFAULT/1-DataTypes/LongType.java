
public class LongType {
	
	public static void methods() {
		long num1 = 5L;
		long num2 = 7L;

		// compare Long if lower -1 higher 1 equal 0
		compare(num1, num2);

		// get MAX or MIN value of Long
		max(num1, num2);
		min(num1, num2);

		// get Longs SUM
		sum(num1, num2);

		String number = "5";
		char number2 = '6';

		// Parse String to Long type
		parseLong(number);

		// Parse String/Char to to Long type
		valueOf(number, number2);

		// Long to String type
		toString(num1);

		// gets MAX and MIN value from Long ENUM
		maxAndMinValueENUM();
	}

    private static void sum(long num1, long num2) {
        long sumInt = Long.sum(num1, num2);
        System.out.println("Sum: " + sumInt);
    }

    private static void toString(long num1) {
        String numberStr = Long.toString(num1);
        System.out.println("ToString: " + numberStr);
    }

    private static void valueOf(String number, char number2) {
        long numberLong = Long.valueOf(number);
        System.out.println("ValueOf from String: " + numberLong);
        long numberLong2 = Long.valueOf(String.valueOf(number2)); // Converting char to String first
        System.out.println("ValueOf from char: " + numberLong2);
    }

    private static void parseLong(String number) {
        long numberLong = Long.parseLong(number);
        System.out.println("ParseLong: " + numberLong);
    }

    private static void min(long num1, long num2) {
        long minLong = Long.min(num1, num2);
        System.out.println("Min: " + minLong);
    }

    private static void max(long num1, long num2) {
        long maxLong = Long.max(num1, num2);
        System.out.println("Max: " + maxLong);
    }

    private static void maxAndMinValueENUM() {
        long maxLong = Long.MAX_VALUE;
        System.out.println("Max Value (from ENUM): " + maxLong);
        long minLong = Long.MIN_VALUE;
        System.out.println("Min Value (from ENUM): " + minLong);
    }

    private static void compare(long num1, long num2) {
        int lower = Long.compare(num1, num2);
        System.out.println("Comparison (num1 < num2): " + lower);

        int higher = Long.compare(num2, num1);
        System.out.println("Comparison (num2 > num1): " + higher);

        int equals = Long.compare(num1, num1);
        System.out.println("Comparison (num1 == num1): " + equals);
    }
}
