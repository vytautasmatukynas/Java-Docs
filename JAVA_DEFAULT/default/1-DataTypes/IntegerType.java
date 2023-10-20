
public class IntegerType {

	public static void methods() {
		int num1 = 5;
		int num2 = 7;

		// compare Integer if lower -1 higher 1 equal 0
		compare(num1, num2);

		// get MAX or MIN value of Integer
		max(num1, num2);
		min(num1, num2);

		// get Integers SUM
		sum(num1, num2);

		String number = "5";
		char number2 = '6';

		// Parse String to Integer type
		parseInt(number);

		// Parse String/Char to to Integer type
		valueOf(number, number2);

		// Integer to String type
		toSTring(num1);
		
		// gets MAX and MIN value from Integer ENUM
		maxAndMinValueENUM();
	}

    private static void sum(int num1, int num2) {
        int sumInt = Integer.sum(num1, num2);
        System.out.println("Sum: " + sumInt);
    }

    private static void toSTring(int num1) {
        String numberStr = Integer.toString(num1);
        System.out.println("ToString: " + numberStr);
    }

    private static void valueOf(String number, char number2) {
        int numberInt = Integer.valueOf(number);
        System.out.println("ValueOf from String: " + numberInt);
        int numberInt2 = Integer.valueOf(String.valueOf(number2)); // Converting char to String first
        System.out.println("ValueOf from char: " + numberInt2);
    }

    private static void parseInt(String number) {
        int numberInt = Integer.parseInt(number);
        System.out.println("ParseInt: " + numberInt);
    }

    private static void min(int num1, int num2) {
        int minInt = Integer.min(num1, num2);
        System.out.println("Min: " + minInt);
    }

    private static void max(int num1, int num2) {
        int maxInt = Integer.max(num1, num2);
        System.out.println("Max: " + maxInt);
    }

    private static void maxAndMinValueENUM() {
        int maxInt = Integer.MAX_VALUE;
        System.out.println("Max Value (from ENUM): " + maxInt);
        int minInt = Integer.MIN_VALUE;
        System.out.println("Min Value (from ENUM): " + minInt);
    }

    private static void compare(int num1, int num2) {
        int lower = Integer.compare(num1, num2);
        System.out.println("Comparison (num1 < num2): " + lower);

        int higher = Integer.compare(num2, num1);
        System.out.println("Comparison (num2 > num1): " + higher);

        int equals = Integer.compare(num1, num1);
        System.out.println("Comparison (num1 == num1): " + equals);
    }
}
