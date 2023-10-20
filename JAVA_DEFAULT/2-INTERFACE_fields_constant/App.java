
/**
 * Interface can have fields, but they have to be constant
 */
public class App {
    public static void main(String[] args) {
        int max = MyConstants.MAX_VALUE;
        String appName = MyConstants.APPLICATION_NAME;
        
        System.out.println("Max value: " + max);
        System.out.println("Application name: " + appName);
    }
}


interface MyConstants {
    // Constant fields (public, static, final)
    int MAX_VALUE = 100;
    String APPLICATION_NAME = "MyApp";
}