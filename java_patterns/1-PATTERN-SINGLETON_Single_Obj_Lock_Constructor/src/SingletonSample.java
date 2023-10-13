import java.util.ArrayList;

/**
 * SINGLE OBJECT. Has locked instance and this will be single object always
 */

public class SingletonSample {
	
	private ArrayList<String> list = new ArrayList<String>();
    private static SingletonSample instance; // Private static instance variable
    
    // Private constructor to prevent instantiation from other classes
    private SingletonSample() {
    	// Initialization code, if needed
        System.out.println("This object is created only once.");
    }

    // Public static method to get the Singleton instance
    public static SingletonSample getInstance() {
        if (instance == null) {
            instance = new SingletonSample();
        }
        return instance;
    }

	public static void setInstance(SingletonSample instance) {
		SingletonSample.instance = instance;
	}

    
    public void add(String string) {
    	list.add(string);
    	System.out.println(list);
    }
    
    public void print() {
    	System.out.println(list);
    }
   
}
