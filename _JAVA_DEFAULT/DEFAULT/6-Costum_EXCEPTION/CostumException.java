
// Main class
public class CostumException {
    public static void main(String[] args) {
        Example example = new Example();
        try {
            // Call the method that might throw the custom exception
            example.performTask(-5);
        } catch (CustomException e) {
            // Catch and handle the custom exception
            System.out.println("Custom Exception caught: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

// Custom exception class
class CustomException extends Exception {
    // Constructor
    public CustomException(String message) {
        super(message);
    }
}

// Example class using the custom exception
class Example {
    // Method that throws the custom exception
    public void performTask(int value) throws CustomException {
        if (value < 0) {
            throw new CustomException("Value cannot be negative");
        }
        // Perform some task here
    }
}

