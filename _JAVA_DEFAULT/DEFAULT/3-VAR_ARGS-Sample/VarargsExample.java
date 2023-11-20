public class VarargsExample {

    // Method that takes a variable number of arguments and calculates their sum
    static int sumValues(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    // Method that takes a fixed parameter and a variable number of arguments
    static void greet(String greeting, String... names) {
        System.out.print(greeting + " ");
        for (String name : names) {
            System.out.print(name + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(sumValues(1, 2, 3));  // Output: 6
        System.out.println(sumValues(5, 10, 15, 20));  // Output: 50
        System.out.println(sumValues());  // Output: 0 (no arguments)

        greet("Hello", "Alice", "Bob", "Charlie");
        // Output: Hello Alice, Bob, Charlie
    }
}
