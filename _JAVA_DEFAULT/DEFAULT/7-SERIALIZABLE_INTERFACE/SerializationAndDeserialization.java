import java.io.*;

public class SerializationAndDeserialization {
    /**
     * This class demonstrates serialization and deserialization of objects using Java's built-in mechanisms.
     */
    public static void main(String[] args) {
        // Serialize object
        try (FileOutputStream fileOut = new FileOutputStream("object.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            // Create an object of MyClass
            MyClass obj = new MyClass(1, "Example");

            // Write the object to file
            objectOut.writeObject(obj);

            // Print success message
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }

        // Deserialize object
        try (FileInputStream fileIn = new FileInputStream("object.ser");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            // Read object from file
            MyClass obj = (MyClass) objectIn.readObject();

            // Print success message
            System.out.println("Object deserialized successfully.");

            // Print deserialized object details
            System.out.println(obj);
        } catch (IOException | ClassNotFoundException e) {
            // Handle IOException or ClassNotFoundException
            e.printStackTrace();
        }
    }
}

// Define a class that implements Serializable interface
class MyClass implements Serializable {
    private static final long serialVersionUID = 1L; // Unique identifier for versioning

    // Define instance variables
    private int id;
    private String name;

    // Constructor
    public MyClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Override toString method for printing object details
    @Override
    public String toString() {
        return "MyClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


