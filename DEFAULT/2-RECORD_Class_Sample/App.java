public class App {

    public static void main(String[] args) {
        // Create instances of the Greeting record
        Greeting greeting1 = new Greeting(1L, "Hello, world");
        Greeting greeting2 = new Greeting(2L, "Hi there");

        // Access the components using accessor methods
        long id1 = greeting1.id();
        String content1 = greeting1.content();
        long id2 = greeting2.id();
        String content2 = greeting2.content();

        // Print the greetings
        System.out.println("Greeting 1: " + greeting1);
        System.out.println("Greeting 2: " + greeting2);

        // Compare two greetings for equality
        boolean areEqual = greeting1.equals(greeting2);
        System.out.println("Are the greetings equal? " + areEqual);

        /*
        This would look like if your using normal class

        // Create instances of the Greeting class
        Greeting greeting1 = new Greeting(1L, "Hello, world");
        Greeting greeting2 = new Greeting(2L, "Hi there");

        // Access the components using getter methods
        long id1 = greeting1.getId();
        String content1 = greeting1.getContent();
        long id2 = greeting2.getId();
        String content2 = greeting2.getContent();

        // Print the greetings
        System.out.println("Greeting 1: " + greeting1);
        System.out.println("Greeting 2: " + greeting2);

        // Compare two greetings for equality using custom equals method
        boolean areEqual = greeting1.equals(greeting2);
        System.out.println("Are the greetings equal? " + areEqual);
         */
    }
}
