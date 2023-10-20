
public class DoubleType {
	
	public static void methods() {
		double num1 = 5.1;
		double num2 = 7.2;

		// compare Double if lower -1 higher 1 equal 0
		compare(num1, num2);

		// get MAX or MIN value of Double
		max(num1, num2);
		min(num1, num2);

		// get Doubles SUM
		sum(num1, num2);

		String number = "5.5";
		char number2 = '6';

		// Parse String to Double type
		parseDouble(number);

		// Parse String/Char to to Double type
		valueOf(number, number2);

		// Double to String type
		toString(num1);

		// gets MAX and MIN value from Double ENUM
		maxAndMinValueENUM();
	}

    private static void sum(double num1, double num2) {
        double sumInt = Double.sum(num1, num2);
        System.out.println("Sum: " + sumInt);
    }

    private static void toString(double num1) {
        String numberStr = Double.toString(num1);
        System.out.println("ToString: " + numberStr);
    }

    private static void valueOf(String number, char number2) {
        double numberDouble = Double.valueOf(number);
        System.out.println("ValueOf from String: " + numberDouble);
        
        double numberDouble2 = Double.valueOf(number2);
        System.out.println("ValueOf from char: " + numberDouble2);
    }

    private static void parseDouble(String number) {
        double numberDouble = Double.parseDouble(number);
        System.out.println("ParseDouble: " + numberDouble);
    }

    private static void min(double num1, double num2) {
        double minDouble = Double.min(num1, num2);
        System.out.println("Min: " + minDouble);
    }

    private static void max(double num1, double num2) {
        double maxDouble = Double.max(num1, num2);
        System.out.println("Max: " + maxDouble);
    }

    private static void maxAndMinValueENUM() {
        double maxDouble = Double.MAX_VALUE;
        System.out.println("Max Value (from ENUM): " + maxDouble);
        
        double minDouble = Double.MIN_VALUE;
        System.out.println("Min Value (from ENUM): " + minDouble);
    }

    private static void compare(double num1, double num2) {
        int lower = Double.compare(num1, num2);
        System.out.println("Comparison (num1 < num2): " + lower);

        int higher = Double.compare(num2, num1);
        System.out.println("Comparison (num2 > num1): " + higher);

        int equals = Double.compare(num1, num1);
        System.out.println("Comparison (num1 == num1): " + equals);
    }

}
