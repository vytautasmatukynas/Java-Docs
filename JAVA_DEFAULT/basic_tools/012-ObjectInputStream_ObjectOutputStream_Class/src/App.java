import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * reading and writing objects to and from streams
 * used to read objects from an input stream and is typically used in conjunction with ObjectOutputStream for serializing and deserializing objects
 */

public class App {

	public static void main(String[] args) {
		File file = createFile();
		
//		Serialization is the process of converting a Java object into a binary format. This binary format can be saved to a file or sent over a network.
//		To make a class serializable, it should implement the Serializable interface.
//		You use an ObjectOutputStream to serialize objects and write them to an output stream
		outputStream(file);
		
//	    Deserialization is the process of recreating a Java object from the binary data. The class should have the same structure as when it was serialized.
//	    You use an ObjectInputStream to deserialize objects and read them from an input stream.
        inputStream(file);

	}

	private static File createFile() {
		File file = new File("person.ser");
		if (file.exists()) {
			System.out.println("File exists");
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	private static void inputStream(File file) {
		// Create a FileInputStream to read from the file
        // Create an ObjectInputStream to read objects from the file
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){

            // Read the object from the file
            Person person = (Person) objectInputStream.readObject();
            
            System.out.println("Object has been deserialized:");
            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

	private static void outputStream(File file) {
		// Create a FileOutputStream to write to a file
		// Create an ObjectOutputStream to write objects to the file
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            // Create an object to be serialized
            Person person = new Person("John", 30);
            
            // Write the object to the file
            objectOutputStream.writeObject(person);
            
            System.out.println("Object has been serialized and written to the file.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
