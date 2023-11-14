import java.util.ArrayList;

/**
 * SINGLE OBJECT. Has locked instance and this will be single object always
 * Thread safe version
 */

public class SingletonSample {
	
	private ArrayList<String> list = new ArrayList<String>();
	
	// Private constructor to prevent instantiation from other classes
    private SingletonSample() {
        // Initialization code, if needed
    	System.out.println("This object is created only once.");
    }

    // Nested static class to hold the Singleton instance
    private static class SingletonHelper {
        private static final SingletonSample instance = new SingletonSample();
    }

    // Public method to get the Singleton instance
    public static SingletonSample getInstance() {
        return SingletonHelper.instance;
    }
    
    public void add(String string) {
    	list.add(string);
    	System.out.println(list);
    }
    
    public void print() {
    	System.out.println(list);
    }
   
}
