
public class FloatType {
	
	public static void methods() {
		float num1 = 5.1f;
		float num2 = 7.2f;

		// compare Float if lower -1 higher 1 equal 0
		compare(num1, num2);

		// get MAX or MIN value of Float
		max(num1, num2);
		min(num1, num2);

		// get Floats SUM
		sum(num1, num2);

		String number = "5.5";
		char number2 = '6';

		// Parse String to Float type
		parseFloat(number);

		// Parse String/Char to to Float type
		valueOf(number, number2);

		// Float to String type
		toString(num1);

		// gets MAX and MIN value from Float ENUM
		maxAndMinValueENUM();
	}


    private static void sum(float num1, float num2) {
        float sumInt = Float.sum(num1, num2);
        System.out.println("Sum: " + sumInt);
    }

    private static void toString(float num1) {
        String numberStr = Float.toString(num1);
        System.out.println("ToString: " + numberStr);
    }

    private static void valueOf(String number, char number2) {
        float numberFloat = Float.valueOf(number);
        System.out.println("ValueOf from String: " + numberFloat);
        float numberFloat2 = Float.valueOf(String.valueOf(number2)); // Converting char to String first
        System.out.println("ValueOf from char: " + numberFloat2);
    }

    private static void parseFloat(String number) {
        float numberFloat = Float.parseFloat(number);
        System.out.println("ParseFloat: " + numberFloat);
    }

    private static void min(float num1, float num2) {
        float minFloat = Float.min(num1, num2);
        System.out.println("Min: " + minFloat);
    }
    
    private static void max(float num1, float num2) {
        float maxFloat = Float.max(num1, num2);
        System.out.println("Max: " + maxFloat);
    }

    private static void maxAndMinValueENUM() {
        float maxFloat = Float.MAX_VALUE;
        System.out.println("Max Value (from ENUM): " + maxFloat);
        float minFloat = Float.MIN_VALUE;
        System.out.println("Min Value (from ENUM): " + minFloat);
    }

    private static void compare(float num1, float num2) {
        int lower = Float.compare(num1, num2);
        System.out.println("Comparison (num1 < num2): " + lower);

        int higher = Float.compare(num2, num1);
        System.out.println("Comparison (num2 > num1): " + higher);

        int equals = Float.compare(num1, num1);
        System.out.println("Comparison (num1 == num1): " + equals);
    }

}
