import java.util.Scanner;

public class ScannerClass {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
        int num = readInteger(scanner);
        long num1 = readLong(scanner);
        float fl = readFloat(scanner);
        double dbl = readDouble(scanner);
        String str = readString(scanner);
        boolean bool = readBoolean(scanner);
        char ch = readChar(scanner);

        System.out.println("You entered:");
        System.out.println("Integer: " + num);
        System.out.println("Long: " + num1);
        System.out.println("Float: " + fl);
        System.out.println("Double: " + dbl);
        System.out.println("String: " + str);
        System.out.println("Boolean: " + bool);
        System.out.println("Character: " + ch);

        scanner.close();
        
	}
        
    public static int readInteger(Scanner scanner) {
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();
        return num;
    }
    
    public static long readLong(Scanner scanner) {
    	System.out.print("Enter an integer: ");
    	long num = scanner.nextLong();
    	return num;
    }

    public static float readFloat(Scanner scanner) {
    	System.out.print("Enter a double: ");
    	float num = scanner.nextFloat();
    	return num;
    }
    
    public static double readDouble(Scanner scanner) {
        System.out.print("Enter a double: ");
        double num = scanner.nextDouble();
        return num;
    }

    public static String readString(Scanner scanner) {
        System.out.print("Enter a string: ");
        scanner.nextLine(); // Consume newline left by previous nextInt/nextDouble
        String input = scanner.nextLine();
        return input;
    }

    public static boolean readBoolean(Scanner scanner) {
        System.out.print("Enter a boolean (true or false): ");
        boolean value = scanner.nextBoolean();
        return value;
    }

    public static char readChar(Scanner scanner) {
        System.out.print("Enter a character: ");
        char ch = scanner.next().charAt(0);
        return ch;
    }


}
