
public class PrimiviteMethods {

	public static void main(String[] args) {

		// Primitive types and operators for them
		typesAndClasses();
		compare();
		allOperators();
		convertSTringToInt();
		basicSample();

	}

	private static void typesAndClasses() {
		// what is what
		char letter = 'a'; // This is a primitive char variable.
		Character letter_2 = 'a'; // This is an object of the Character class.

		// Integral Data Types
		byte myByte = 127; // 8-bit signed integer (-128 to 127)
		short myShort = 32767; // 16-bit signed integer (-32,768 to 32,767)
		int myInt = 2147483647; // 32-bit signed integer (-2^31 to 2^31-1)
		long myLong = 9223372036854775807L; // 64-bit signed integer (-2^63 to 2^63-1, note the 'L' suffix)

		char myChar = 'A'; // 16-bit Unicode character (0 to 65,535)

		// Floating-Point Data Types
		float myFloat = 3.14f; // 32-bit floating-point number (approximately ±3.40282347E+38F)
		double myDouble = 2.71828; // 64-bit floating-point number (approximately ±1.79769313486231570E+308)

		// Boolean Data Type
		boolean isJavaFun = true; // Represents true or false

		// Output
		System.out.println("byte: " + myByte);
		System.out.println("short: " + myShort);
		System.out.println("int: " + myInt);
		System.out.println("long: " + myLong);
		System.out.println("char: " + myChar);
		System.out.println("float: " + myFloat);
		System.out.println("double: " + myDouble);
		System.out.println("boolean: " + isJavaFun);

		// Wrapper Classes
		Byte byteWrapper = Byte.valueOf(myByte); // Byte

		Short shortWrapper = Short.valueOf(myShort); // Short

		Integer intWrapper = Integer.valueOf(myInt); // Integer

		Long longWrapper = Long.valueOf(myLong); // Long
		String longStringName = Long.toString(myLong); // Converts to string "9223372036854775807"

		Character charWrapper = Character.valueOf(myChar); // Character
		char charLower = Character.toLowerCase(myChar); // Makes char lower 'a'

		Float floatWrapper = Float.valueOf(myFloat); // Float
		int floatToInt = (int) myFloat; // Converts to Integer 3

		Double doubleWrapper = Double.valueOf(myDouble); // Double

		Boolean booleanWrapper = Boolean.valueOf(isJavaFun); // Boolean

		System.out.println("Byte: " + byteWrapper);
		System.out.println("Short: " + shortWrapper);
		System.out.println("Integer: " + intWrapper);
		System.out.println("Long: " + longWrapper);
		System.out.println("Long to String: " + longStringName);
		System.out.println("Character: " + charWrapper);
		System.out.println("Character to Lower: " + charLower);
		System.out.println("Float: " + floatWrapper);
		System.out.println("Float to Int: " + floatToInt);
		System.out.println("Double: " + doubleWrapper);
		System.out.println("Boolean: " + booleanWrapper);
	}

	private static void compare() {
		// Comparison Operations
		boolean isEqual = (5 == 8); // Equal: true
		System.out.println("Equal: " + isEqual);

		boolean isNotEqual = (4 != 7); // Not Equal: true
		System.out.println("Not Equal: " + isNotEqual);

		boolean isGreaterThan = (10 > 5); // Greater Than: true
		System.out.println("Greater Than: " + isGreaterThan);

		boolean isLessThan = (3 < 9); // Less Than: true
		System.out.println("Less Than: " + isLessThan);

		boolean isGreaterOrEqual = (7 >= 7); // Greater Or Equal: true
		System.out.println("Greater Or Equal: " + isGreaterOrEqual);

		boolean isLessOrEqual = (2 <= 2); // Less Or Equal: true
		System.out.println("Less Or Equal: " + isLessOrEqual + "\n");

	}

	private static void convertSTringToInt() {
		// convert integer to string
		System.out.println(Integer.toString(5 + 6) + "\n"); // string (11)

		// convert string to integer
		String a = "8";
		String b = "7";
		String c = a + b;
		System.out.println(c); // get string "87"
		int count = Integer.parseInt(c);
		System.out.println(count + "\n"); // get integer 13
	}

	private static void allOperators() {
		// Arithmetic Operations
		int additionResult = 5 + 3; // Sum: 8
		System.out.println("Sum: " + additionResult);

		int subtractionResult = 8 - 3; // Difference: 5
		System.out.println("Difference: " + subtractionResult);

		int multiplicationResult = 4 * 6; // Multiply: 24
		System.out.println("Multiply: " + multiplicationResult);

		int divisionResult = 10 / 2; // Division : 5
		System.out.println("Division : " + divisionResult);

		int modulusResult = 10 % 3; // Modulus: 1
		System.out.println("Modulus : " + modulusResult + "\n");

		// Perform compound assignments
		int value1 = 10;
		value1 += 5; // Equivalent to: value1 = value1 + 5
		System.out.println("After += 5 for value1: " + value1);

		int value2 = 10;
		value2 -= 3; // Equivalent to: value2 = value2 - 3
		System.out.println("After -= 3 for value2: " + value2);

		int value3 = 10;
		value3 *= 2; // Equivalent to: value3 = value3 * 2
		System.out.println("After *= 2 for value3: " + value3);

		int value4 = 10;
		value4 /= 4; // Equivalent to: value4 = value4 / 4
		System.out.println("After /= 4 for value4: " + value4);

		int value5 = 10;
		value5 %= 3; // Equivalent to: value5 = value5 % 3
		System.out.println("After %= 3 for value5: " + value5 + "\n");
	}

	private static void basicSample() {
		System.out.println(5 * 6); // integer (30)
		System.out.println(5 / 6); // integer (0)
		System.out.println((float) 5 / 6); // float (0.8333333)
		System.out.println("" + (5 + 6)); // string (11)
		System.out.println(5 + 6); // integer (11)
		System.out.println(5 - 6); // integer (-1)
		System.out.println(Math.abs(5 - 6)); // integer (1)
		System.out.println((float) Math.sqrt(5)); // integer (2.236068)
		System.out.println(Math.sqrt(5)); // integer (2.2360679749979)
		System.out.println((int) Math.sqrt(5)); // integer (2)
		System.out.println((int) Math.sqrt(25)); // integer (5)
		System.out.println(Math.pow(5, 2) + "\n"); // integer (25)
	}

}
